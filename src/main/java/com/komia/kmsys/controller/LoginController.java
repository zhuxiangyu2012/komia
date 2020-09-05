package com.komia.kmsys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komia.common.KomiaAjaxInfo;
import com.komia.kmsys.po.User;
import com.komia.util.RSAUtil;

@RestController
@RequestMapping("/")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping(value="/kmlogin")
	public ResponseEntity<KomiaAjaxInfo> login(String username,String password) {
		Subject subject = SecurityUtils.getSubject();
		password = RSAUtil.privateDecrypt(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		subject.login(token);
		User user = (User) subject.getPrincipal();
		
		return ResponseEntity.ok(KomiaAjaxInfo.success(user));
	}
	
	@GetMapping(value="/currentUser")
	public ResponseEntity<KomiaAjaxInfo> getLoggedUser() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		return ResponseEntity.ok(KomiaAjaxInfo.success(user));
	}
}
