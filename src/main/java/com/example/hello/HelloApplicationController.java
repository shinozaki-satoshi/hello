package com.example.hello;

import java.util.List;

import com.example.hello.entity.Theme;
import com.example.hello.service.ThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloApplicationController {

    @Autowired
    ThemeService ThemeService;

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
}