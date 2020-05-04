package com.jq.pojo;

import java.io.Serializable;

public class WebUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6668503062662350490L;
	
	 private Long snId;// 自增ID
	 private String userName;// 用户名
	 private String password;// 密码
	public Long getSnId() {
		return snId;
	}
	public void setSnId(Long snId) {
		this.snId = snId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "WebUser [snId=" + snId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
