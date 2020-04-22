package com.komia.common;

public class KomiaAjaxInfo {
	private String code;
	private String msg = "";
	private Boolean success;
	private Object data;
	
	public static KomiaAjaxInfo success(Object data) {
		KomiaAjaxInfo result = new KomiaAjaxInfo();
		result.success = true;
		result.data = data;
		return result;
	}
	
	public static KomiaAjaxInfo success(Object data,String code) {
		KomiaAjaxInfo result = new KomiaAjaxInfo();
		result.success = true;
		result.data = data;
		result.code = code;
		return result;
	}
	public static KomiaAjaxInfo fail(String msg) {
		KomiaAjaxInfo result = new KomiaAjaxInfo();
		result.success = false;
		result.msg = msg;
		return result;
	}
	
	public static KomiaAjaxInfo fail(String msg,String code) {
		KomiaAjaxInfo result = new KomiaAjaxInfo();
		result.success = false;
		result.msg = msg;
		result.code = code;
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public Boolean getSuccess() {
		return success;
	}
	public String getCode() {
		return code;
	}
}
