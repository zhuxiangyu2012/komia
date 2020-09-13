package com.komia.kmsys.vo;

public class UserSearchVo extends CommonSearch{
	private String username;
	private String nickname;
	private Integer status; // 0 锁定  1 正常
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
