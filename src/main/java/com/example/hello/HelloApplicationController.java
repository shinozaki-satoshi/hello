package com.example.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApplicationController {
    @RequestMapping("/")  // ルートへこのメソッドをマップする
    public String test() {
        return "Hello World";
    }

}
