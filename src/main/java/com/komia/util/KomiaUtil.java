package com.komia.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
	
	/**
	 * 将数据校验的错误信息转换成MapList
	 * @param br
	 * @return
	 */
	public static HashMap<String,List<String>> getErrorsMapList(BindingResult br){
		List<FieldError> fieldErrors = br.getFieldErrors();
		HashMap<String,List<String>> errorMap = new HashMap<String,List<String>>();
		
		if(fieldErrors != null && fieldErrors.size() >0) {
			List<String> temp = null;
			for (FieldError fieldError : fieldErrors) {
				temp = errorMap.get(fieldError.getField());
				if(temp == null) {
					temp = new ArrayList<String>();
					errorMap.put(fieldError.getField(), temp);
				}
				temp.add(fieldError.getDefaultMessage());
	        }
		}
		
		return errorMap;
	}
}
