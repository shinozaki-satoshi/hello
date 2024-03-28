package com.example.hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloApplicationController {
    @RequestMapping(value="/", method = RequestMethod.GET)  // ルートへこのメソッドをマップする
    public String test(Model model) {
        model.addAttribute("msg", "Hello World!!!");
        return "hello";
    }

}
