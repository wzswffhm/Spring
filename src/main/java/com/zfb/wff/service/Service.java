package com.zfb.wff.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zfb.wff.exception.NoMoneyException;
import com.zfb.wff.mapper.ExchangeMapper;
import com.zfb.wff.mapper.UserMapper;
import com.zfb.wff.pojo.Exchange;
import com.zfb.wff.pojo.User;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface{

	@Autowired
	UserMapper userMapper;
	
	// 注入上下文
		@Autowired
		ApplicationContext context;
	
	@Autowired
	ExchangeMapper exchangeMapper;
	
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = NoMoneyException.class)
	@Override
	public Exchange exchange(long from, long to, BigDecimal money) throws NoMoneyException {
		Exchange exchange = new Exchange();
		exchange.setFrom(from);
		exchange.setTo(to);
		exchange.setMoney(money);
		
		ServiceInterface serviceInterface = context.getBean(ServiceInterface.class);
		serviceInterface.createExchange(exchange);
		
		BigDecimal yue = userMapper.getMoneyById(from);
		if(yue.doubleValue() < money.doubleValue()) {
			throw new NoMoneyException();
		}
		
		userMapper.setMoneyById(from, money.negate());
		userMapper.setMoneyById(to, money);
		exchangeMapper.updateStatusTrue(exchange.getId());
		
		return exchange;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Exchange createExchange(Exchange exchange) {
		
		exchangeMapper.create(exchange);
		System.out.println("订单号为：" + exchange.getId());
		return exchange;
	}
	
}
