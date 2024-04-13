package com.example.hello;

import java.util.List;

import com.example.hello.entity.Answer;
import com.example.hello.entity.Theme;
import com.example.hello.service.AnswerService;
import com.example.hello.service.ThemeService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloApplicationController {

    @Autowired
    ThemeService ThemeService;

    @Autowired
    AnswerService AnswerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public String home(Model model) {
        return "theme";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String theme(HttpSession session, Model model) {
        List<Theme> themes = ThemeService.getAllTheme();
        model.addAttribute("themes", themes);

        // セッションを破棄する
        session.invalidate();

        return "home";
    }

    /* 
     回答画面群 
    */
    @RequestMapping(value = "/answer/{themeId}", method = RequestMethod.GET)
    public String answer(HttpSession session, @PathVariable("themeId") String themeId, Model model, RedirectAttributes redirectAttributes) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        //戻るボタン時に格納
        String answer = (String) session.getAttribute("answer");
        model.addAttribute("answer", answer); 

        return "answer";
    }

    @RequestMapping(value = "/answer_confirm/{themeId}", method = RequestMethod.POST)
    public String answer_confirm(HttpSession session, @PathVariable("themeId") String themeId,
            @RequestParam("answer") String answer, Model model) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);
        model.addAttribute("answer", answer);
        session.setAttribute("answer", answer);
        return "answer_confirm";
    }

    @RequestMapping(value = "/answer_back/{themeId}", method = RequestMethod.GET)
    public String answer_back(HttpSession session, @PathVariable("themeId") String themeId,
            RedirectAttributes redirectAttributes) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        redirectAttributes.addFlashAttribute("theme", theme);
        return "redirect:/answer/{themeId}";
    }

    @RequestMapping(value = "/answer_finish/{themeId}", method = RequestMethod.POST)
    public String answer_finish(HttpSession session, @PathVariable("themeId") String themeId, Model model) {
        String sessionAnser = (String) session.getAttribute("answer");

        // 回答登録
        AnswerService.registerAnswer(Integer.parseInt(themeId), sessionAnser);

        // セッションを破棄する
        session.invalidate();

        return "finish";
    }
    /* 
     /回答画面群 
    */

    /* 
    投票画面群 
    */
    @RequestMapping(value = "/vote/{themeId}", method = RequestMethod.GET)
    public String vote(HttpSession session, @PathVariable("themeId") String themeId, Model model) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        List<Answer> answers = AnswerService.getAnswers(Integer.parseInt(themeId));
        model.addAttribute("answers", answers);

        return "vote";
    }

    @RequestMapping(value = "/vote_confirm/{answerId}", method = RequestMethod.GET)
    public String vote_confirm(HttpSession session, @PathVariable("answerId") String answerId, Model model) {
        Answer answer = AnswerService.getAnswer(Integer.parseInt(answerId));
        model.addAttribute("answer", answer);

        Theme theme = ThemeService.getTheme(Integer.parseInt(answer.getThemeId()));
        model.addAttribute("theme", theme);
        return "vote_confirm";
    }

    @RequestMapping(value = "/vote_finish/{answerId}", method = RequestMethod.POST)
    public String vote_finish(HttpSession session, @PathVariable("answerId") String answerId, Model model) {

        // 投票登録
        AnswerService.voteAnswer(Integer.parseInt(answerId));

        // セッションを破棄する
        session.invalidate();

        return "finish";
    }

    /* 
     /投票画面群 
    */
}