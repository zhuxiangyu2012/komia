package com.komia.kmsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.komia.kmsys.po.User;
import com.komia.kmsys.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public User addUser(User user) {
		return userService.add(user);
	}
}
