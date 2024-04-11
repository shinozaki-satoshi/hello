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

import javax.servlet.http.HttpServletRequest;
@Controller
public class HelloApplicationController {

    @Autowired
    ThemeService ThemeService;

    @Autowired
    AnswerService AnswerService;

    @Autowired
	private HttpSession session;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value="/theme", method = RequestMethod.GET)
    public String home(Model model) {
        return "theme";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String theme(Model model) {
        List<Theme> themes = ThemeService.getAllTheme();
        model.addAttribute("themes", themes);
        return "home"; 
    }

    @RequestMapping(value="/anser/{themeId}", method = RequestMethod.GET)
    public String anser(@PathVariable("themeId") String themeId, Model model) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);
        return "anser"; 
    }

    @RequestMapping(value="/anser_confirm/{themeId}", method = RequestMethod.POST)
    public String anser_confirm(HttpSession session,@PathVariable("themeId") String themeId, @RequestParam("anser") String anser, Model model) {
        Theme theme = ThemeService.getTheme(Integer.parseInt(themeId));
        model.addAttribute("theme", theme);
        model.addAttribute("anser", anser);
        session.setAttribute("anser", anser);
        return "anser_confirm"; 
    }

    @RequestMapping(value="/anser_finish/{themeId}", method = RequestMethod.POST)
    public String anser_finish(HttpSession session, @PathVariable("themeId") String themeId, Model model) {
        String sessionAnser = (String) session.getAttribute("anser");
        model.addAttribute("theme", themeId);
        model.addAttribute("anser", sessionAnser);
        AnswerService.registerAnswer(Integer.parseInt(themeId), sessionAnser);
        return "finish"; 
}

}