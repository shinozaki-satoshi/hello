package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloApplicationController {
    @RequestMapping(value="/", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String hello(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value="/content", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String content(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "layout/content";
    }
    @RequestMapping(value="/header", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String header(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "layout/header";
    }
    @RequestMapping(value="/layout", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String layout(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "layout/layout";
    }
    @RequestMapping(value="/menu", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String menu(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "layout/menu";
    }
}
