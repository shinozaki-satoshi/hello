package com.example.hello;

import java.util.List;

import com.example.hello.entity.Theme;
import com.example.hello.service.HelloAplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloApplicationController {

    @Autowired
    HelloAplicationService HelloAplicationService;

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
        List<Theme> themes = HelloAplicationService.getTheme();
        model.addAttribute("themes", themes);
        return "home"; 
    }
}
