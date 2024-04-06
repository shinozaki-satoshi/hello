package com.example.hello;

import java.util.ArrayList;
import java.util.List;

import com.example.hello.entity.Theme;
import com.example.hello.mapper.ThemeMapper;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloApplicationController {

    private final ThemeMapper themeMapper;

    //@Autowired
    public HelloApplicationController(ThemeMapper themeMapper) {
        this.themeMapper = themeMapper;
    }

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
        List<Theme> themes = new ArrayList<>();//= themeMapper.findAllThemes(); // ThemeMapperを使用してすべてのレコードを取得する
        themes.add(new Theme("01", "themeIdValue", "themeNameValue", "deadlineFromValue", "deadlineToValue"));
        themes.add(new Theme("02", "themeIdValue", "themeNameValue", "deadlineFromValue", "deadlineToValue"));
        model.addAttribute("themes", themes);
        return "home"; 
    }
}
