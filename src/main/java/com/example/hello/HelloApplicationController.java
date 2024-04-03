package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloApplicationController {
    @RequestMapping(value="/hello", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String hello(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String header(Model model) {
        return "home";
    }
}
