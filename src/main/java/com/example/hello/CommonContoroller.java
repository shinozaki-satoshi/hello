package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hello.bean.Account;
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
	public String registUserSuc(Model model,Account account) {
		try {
            // ユーザーの登録を試みる
            UserService.registUser(account.getUsername(), account.getPassword());
            return "login";
        } catch (DataIntegrityViolationException e) {
            // ユーザーの登録に失敗した場合の処理
			String errorMessage ="ユーザの登録に失敗しました。存在するユーザ名です。";
			model.addAttribute("errorMessage", errorMessage);
			return "registUser"; 
        }
	}
}
