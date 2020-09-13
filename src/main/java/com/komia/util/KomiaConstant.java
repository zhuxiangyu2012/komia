package com.komia.util;

public class KomiaConstant {
	//错误参数
	public static final String ERROR_CODE_BADPARAM = "bad_param";
	
	//默认密码
	public static final String DEFAULT_PASSWORD = "Hello_Komia";
	
	//最多登陆失败次数
	public static final int  DEFAULT_PAGE_SIZE = 8;
		
	//最多登陆失败次数
	public static final int  MAX_LOGIN_FAIL_CNT = 10;
	
	//等于或超过该次数，提示剩余尝试次数
	public static final int  REMIND_LOGIN_FAIL_CNT = 6;
	
	//未认证
	public static final String  UN_AUTHENTICATION = "noauthen";
	
	//没有权限
	public static final String  UN_AUTHORIZATION = "noauthor";
	
	//退出登录成功
	public static final String  LOGOUT_SUCCESS = "logoutsuc";
	
	//常规无权限限制URL
	public static final String COMMON_URL = "/common";
}
