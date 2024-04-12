package com.example.hello;

import java.util.List;

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

    @RequestMapping(value = "/anser/{themeId}", method = RequestMethod.GET)
    public String anserFromHome(HttpSession session, @PathVariable("themeId") String themeId, Model model, RedirectAttributes redirectAttributes) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);

        //戻るボタン時に格納
        String anser = (String) session.getAttribute("anser");
        model.addAttribute("anser", anser); 

        return "anser";
    }

    @RequestMapping(value = "/anser_confirm/{themeId}", method = RequestMethod.POST)
    public String anser_confirm(HttpSession session, @PathVariable("themeId") String themeId,
            @RequestParam("anser") String anser, Model model) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);
        model.addAttribute("anser", anser);
        session.setAttribute("anser", anser);
        return "anser_confirm";
    }

    @RequestMapping(value = "/anser_back/{themeId}", method = RequestMethod.GET)
    public String anser_back(HttpSession session, @PathVariable("themeId") String themeId,
            RedirectAttributes redirectAttributes) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        redirectAttributes.addFlashAttribute("theme", theme);
        return "redirect:/anser/{themeId}";
    }

    @RequestMapping(value = "/anser_finish/{themeId}", method = RequestMethod.POST)
    public String anser_finish(HttpSession session, @PathVariable("themeId") String themeId, Model model) {
        String sessionAnser = (String) session.getAttribute("anser");

        // 回答登録
        AnswerService.registerAnswer(Integer.parseInt(themeId), sessionAnser);

        // セッションを破棄する
        session.invalidate();

        return "finish";
    }

}