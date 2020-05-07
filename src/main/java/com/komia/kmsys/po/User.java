package com.komia.kmsys.po;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("SysUser")
public class User implements Serializable{
	private static final long serialVersionUID = 5847984888698536252L;
	
	private int id;
	private String username;
	private String password;
	private String nickname;
	private int failcnt;
	private int status;
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
