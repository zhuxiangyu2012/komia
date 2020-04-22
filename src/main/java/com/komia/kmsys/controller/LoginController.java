package com.komia.kmsys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.komia.common.KomiaAjaxInfo;
import com.komia.kmsys.po.User;

@Controller
@RequestMapping("/")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.getPrincipal()!=null) {
			return "redirect:/home";
		}
		return "login";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	
	
	
	@RequestMapping(value="/kmlogin",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<KomiaAjaxInfo> login(String username,String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		subject.login(token);
		User user = (User) subject.getPrincipal();
		
		return ResponseEntity.ok(KomiaAjaxInfo.success(user));
	}
}
