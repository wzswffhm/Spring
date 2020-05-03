package com.zfb.wff.pojo;

import java.math.BigDecimal;

/**
 * 用户
 * @author 93762
 *
 */
public class User {

	long id;
	
	String username;
	
	String password;
	
	String sex;
	
	String phone;
	
	BigDecimal money;
	
	public User() {
		
	}

	public User(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", phone="
				+ phone + ", money=" + money + "]";
	}
	
	
}
