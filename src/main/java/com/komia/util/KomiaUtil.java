package com.komia.util;

import java.util.Date;

import org.apache.shiro.crypto.hash.Md5Hash;

public class KomiaUtil {
	public static String md5 (String password,String salt) {
		String p = null;
		p = new Md5Hash(password, salt).toHex();
		return p;
	}
	
	public static boolean isEmpty(Object obj) {
		if(obj == null) return true;
		if(obj instanceof String) {
			return "".equals(obj);
		}
		return false;
	}
	
	public static Date add10Minite() {
		Date now = new Date();
		return new Date(now .getTime() + 10*60*1000);
	}
}
