package com.komia.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.komia.common.KomiaAjaxInfo;
import com.komia.util.KomiaConstant;

@RestControllerAdvice
public class KomiaExceptionAdvice {
	private Logger logger = LoggerFactory.getLogger(KomiaExceptionAdvice.class);
	
	@ExceptionHandler(LockedAccountException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public KomiaAjaxInfo handleLockedAccountException(HttpServletRequest request, LockedAccountException exp) {
		logger.error("LockedAccountException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),"LockedAccountException");
	}
	
	@ExceptionHandler(UnknownAccountException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public KomiaAjaxInfo handleUnknownAccountException(HttpServletRequest request, UnknownAccountException exp) {
		logger.error("UnknownAccountException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),"UnknownAccountException");
	}
	
	@ExceptionHandler(IncorrectCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public KomiaAjaxInfo handleIncorrectCredentialsException(HttpServletRequest request, IncorrectCredentialsException exp) {
		logger.error("IncorrectCredentialsException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),"IncorrectCredentialsException");
	}
	
	@ExceptionHandler(InvalidSessionException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public KomiaAjaxInfo handleInvalidSessionException(HttpServletRequest request, InvalidSessionException exp) {
		logger.error("InvalidSessionException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(), KomiaConstant.UN_AUTHENTICATION);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public KomiaAjaxInfo handleAuthorizationException(HttpServletRequest request, AuthorizationException exp) {
		logger.error("AuthorizationException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),KomiaConstant.UN_AUTHORIZATION);
	}

	@ExceptionHandler(KomiaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public KomiaAjaxInfo handleKomiaException(HttpServletRequest request, KomiaException exp) {
		logger.error("komiaException:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),"komiaException");
	}
	  
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public KomiaAjaxInfo handleException(HttpServletRequest request, RuntimeException exp) {
		logger.error("RuntimeException:", exp);
		return KomiaAjaxInfo.fail(exp.getMessage(),"RuntimeException");
	}
	  
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public KomiaAjaxInfo handleException(HttpServletRequest request, Exception exp) {
		logger.error("Exception:", exp);
	    return KomiaAjaxInfo.fail(exp.getMessage(),"Exception");
	}
}