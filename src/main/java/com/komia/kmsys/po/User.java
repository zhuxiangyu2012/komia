package com.komia.kmsys.po;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

@Alias("SysUser")
public class User implements Serializable{
	private static final long serialVersionUID = 5847984888698536252L;
	
	private int id;
	@NotEmpty(message="用户名不能为空")
	private String username;
	private String password;
	@NotEmpty(message="昵称不能为空")
	private String nickname;
	private int failcnt;
	private int status; // 0 锁定  1 正常
	private Date unlockDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUnlockDate() {
		return unlockDate;
	}
	public void setUnlockDate(Date unlockDate) {
		this.unlockDate = unlockDate;
	}
	public int getFailcnt() {
		return failcnt;
	}
	public void setFailcnt(int failcnt) {
		this.failcnt = failcnt;
	}
}
