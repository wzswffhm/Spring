package com.zfb.wff.pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 交易记录
 * 
 * @author 93762
 *
 */
public class Exchange {

	/**
	 * 编号
	 */
	long id;
	
	/**
	 * 交易时间
	 */
	Date time;
	
	/**
	 * 转出
	 */
	long from;
	
	/**
	 * 转入
	 */
	long to;
	
	/**
	 * 交易金额
	 */
	BigDecimal money;
	
	/**
	 * 交易状态
	 */
	char status;
	
	public Exchange() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
