package com.komia.kmsys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.komia.common.KomiaAjaxInfo;

@RestController
public class ErrorController {
	@RequestMapping(value="/unauthor",method=RequestMethod.GET)
	public void unauthor(HttpServletResponse response) throws Exception {
		response.setStatus(403);
		response.setHeader("content-type", "text/json;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader("Cache-Control", "no-cache, must-revalidate"); 
	    KomiaAjaxInfo info = KomiaAjaxInfo.fail("No authorization", "noauthor");
	    String jsonStr = JSON.toJSONString(info);
		response.getWriter().write(jsonStr);
		response.getWriter().flush();
	}
	
	@RequestMapping(value="/unauthen",method=RequestMethod.GET)
	public void unauthen(HttpServletResponse response) throws Exception {
		response.setHeader("content-type", "text/json;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader("Cache-Control", "no-cache, must-revalidate"); 
	    KomiaAjaxInfo info = KomiaAjaxInfo.fail("No authentication", "noauthen");
	    String jsonStr = JSON.toJSONString(info);
		response.getWriter().write(jsonStr);
		response.getWriter().flush();
	}
	
	@RequestMapping(value="/logoutSuc",method=RequestMethod.GET)
	public void logoutSuc(HttpServletResponse response) throws Exception {
		response.setHeader("content-type", "text/json;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader("Cache-Control", "no-cache, must-revalidate"); 
	    KomiaAjaxInfo info = KomiaAjaxInfo.success("Logout Successfully", "logoutsuc");
	    String jsonStr = JSON.toJSONString(info);
		response.getWriter().write(jsonStr);
		response.getWriter().flush();
	}
}
