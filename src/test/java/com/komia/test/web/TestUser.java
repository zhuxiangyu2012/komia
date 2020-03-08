package com.komia.test.web;

import javax.annotation.Resource;

import org.junit.Test;

import com.komia.kmsys.po.User;
import com.komia.kmsys.service.UserService;
import com.komia.test.base.TestBase;
import com.komia.util.KomiaUtil;

public class TestUser extends TestBase{
	@Resource
	private UserService userService;
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername("zhuxya");
		user.setNickname("猪");
		user.setPassword("pwd");
		user.setStatus(1);
		userService.add(user);
		System.out.println(userService);
	}
	@Test
	public void komiaUtilMd5() {
		String s = KomiaUtil.md5("pwd", "username");
		System.out.println(s);
	}
}
