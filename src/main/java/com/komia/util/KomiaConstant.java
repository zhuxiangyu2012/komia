package com.komia.util;

public class KomiaConstant {
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
