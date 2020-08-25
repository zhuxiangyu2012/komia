package com.komia.kmsys.po;

import org.apache.ibatis.type.Alias;

@Alias("SysResource")
public class Resource {
	private int id;
	private String name;
	private String key; 
	private String pkey;
	private String url;
	private int type; // 1  menu  2 resource
	private int rlevel; //层级
	private int rorder;
	private int status;//0 使用  1 不使用  
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLevel() {
		return rlevel;
	}
	public void setLevel(int level) {
		this.rlevel = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPkey() {
		return pkey;
	}
	public void setPkey(String pkey) {
		this.pkey = pkey;
	}
	public int getOrder() {
		return rorder;
	}
	public void setOrder(int order) {
		this.rorder = order;
	}
}
