package com.example.hello;

import java.util.List;

import com.example.hello.bean.Answer;
import com.example.hello.bean.ResultVote;
import com.example.hello.bean.Theme;
import com.example.hello.service.AnswerService;
import com.example.hello.service.ResultVoteService;
import com.example.hello.service.ThemeService;
import com.example.hello.service.UserService;
import com.example.hello.service.VoteService;

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

    @Autowired
    UserService UserService;

    @Autowired
    VoteService VoteService;

    @Autowired
    ResultVoteService ResultVoteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(HttpSession session,Model model) {
        //ユーザーセット
        UserService.getUser(model);

        model.addAttribute("msg", "Hello World!!!");
        
        return "hello";
    }

    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        return "theme";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String theme(HttpSession session, Model model, String username) {
        //ユーザーセット
        UserService.getUser(model);

        // 期限内のレコードを取得
        List<Theme> themes = ThemeService.getAllTheme();
        model.addAttribute("themes", themes);

        // セッションを破棄する
        session.removeAttribute("sessionAnser");

        return "home";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(HttpSession session, Model model) {
        //ユーザーセット
        UserService.getUser(model);

        // 期限外のレコードを取得
        List<Theme> themesOver = ThemeService.getOverTheme();
        model.addAttribute("themesOvers", themesOver);

        // セッションを破棄する
        session.removeAttribute("sessionAnser");

        return "result";
    }

    @RequestMapping(value = "/result_vote/{themeId}", method = RequestMethod.GET)
    public String result_vote(HttpSession session, Model model, @PathVariable("themeId") String themeId) {
        //ユーザーセット
        UserService.getUser(model);

        List<ResultVote> answers = ResultVoteService.getAnswersRank(Integer.parseInt(themeId));
        model.addAttribute("answers", answers);

        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        return "result_vote";
    }

    /* 
     回答画面群 
    */
    @RequestMapping(value = "/answer/{themeId}", method = RequestMethod.GET)
    public String answer(HttpSession session, @PathVariable("themeId") String themeId, Model model, RedirectAttributes redirectAttributes) {
        //ユーザーセット
        UserService.getUser(model);
        
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        //戻るボタン時に格納
        String answer = (String) session.getAttribute("sessionAnser");
        model.addAttribute("answer", answer); 

        return "answer";
    }

    @RequestMapping(value = "/answer_confirm/{themeId}", method = RequestMethod.POST)
    public String answer_confirm(HttpSession session, @PathVariable("themeId") String themeId,
            @RequestParam("answer") String answer, Model model) {
        //ユーザーセット
        UserService.getUser(model);
        
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);
        model.addAttribute("answer", answer);
        session.setAttribute("sessionAnser", answer);
        return "answer_confirm";
    }

    @RequestMapping(value = "/answer_back/{themeId}", method = RequestMethod.GET)
    public String answer_back(HttpSession session, @PathVariable("themeId") String themeId,
            RedirectAttributes redirectAttributes,Model model) {
        //ユーザーセット
        UserService.getUser(model);

        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        redirectAttributes.addFlashAttribute("theme", theme);
        return "redirect:/answer/{themeId}";
    }

    @RequestMapping(value = "/answer_finish/{themeId}", method = RequestMethod.POST)
    public String answer_finish(HttpSession session, @PathVariable("themeId") String themeId, Model model) {
        String sessionAnser = (String) session.getAttribute("sessionAnser");
        //ユーザーセット
        UserService.getUser(model);

        // 回答登録
        AnswerService.registerAnswer(Integer.parseInt(themeId), sessionAnser);

        // セッションを破棄する
        session.removeAttribute("sessionAnser");
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
        //ユーザーセット
        UserService.getUser(model);

        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        List<Answer> answers = AnswerService.getAnswers(Integer.parseInt(themeId));
        model.addAttribute("answers", answers);

        return "vote";
    }

    @RequestMapping(value = "/vote_confirm/{answerId}", method = RequestMethod.GET)
    public String vote_confirm(HttpSession session, @PathVariable("answerId") String answerId, Model model) {
        //ユーザーセット
        UserService.getUser(model);
        
        Answer answer = AnswerService.getAnswer(Integer.parseInt(answerId));
        model.addAttribute("answer", answer);

        Theme theme = ThemeService.getTheme(Integer.parseInt(answer.getThemeId()));
        model.addAttribute("theme", theme);
        return "vote_confirm";
    }

    @RequestMapping(value = "/vote_finish/{answerId}", method = RequestMethod.POST)
    public String vote_finish(HttpSession session, @PathVariable("answerId") String answerId, Model model) {
        //ユーザーセット
        UserService.getUser(model);

        // ユーザー取得
        String userName = UserService.getUserName();

        // 回答ID取得
        Integer answerIdInt = Integer.parseInt(answerId);
        
        // 投票テーマID取得
        Integer themeIdInt = Integer.parseInt(AnswerService.getAnswer(answerIdInt).getThemeId());

        // 投票登録(ユーザ、テーマ、アンサーID)
        VoteService.voteAnswer(userName,themeIdInt,answerIdInt);

        // セッションを破棄する
        session.removeAttribute("sessionAnser");

        return "finish";
    }

    /* 
     /投票画面群 
    */
}