package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hello.entity.Account;
import com.example.hello.service.UserService;

@Controller
public class CommonContoroller {

	@Autowired
    UserService UserService;

    //ここを追加
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/registUser")
	public String registUser() {
		return "registUser";
	}

	@RequestMapping(value = "/registUserSuc", method = RequestMethod.POST)
	public String registUserSuc(Account account) {
		//ここで登録
		UserService.registUser(account.getUsername(),account.getPassword());
		return "login";
	}
}
