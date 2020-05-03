package com.zfb.wff.service;

import java.math.BigDecimal;

import com.zfb.wff.exception.NoMoneyException;
import com.zfb.wff.pojo.Exchange;

public interface ServiceInterface {

	/**
	 * 转账
	 * 
	 * @param from	转出账户
	 * @param to	转入账户
	 * @param money	交易金额
	 * @throws NoMoneyException 
	 * @return 交易记录信息
	 */
	Exchange exchange(long from, long to, BigDecimal money) throws NoMoneyException;
	
	/**
	 * 生成交易记录
	 * 
	 * @param exchange 交易信息
	 * @return
	 */
	Exchange createExchange(Exchange exchange);
}
