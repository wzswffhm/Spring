package com.zfb.wff.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfb.wff.exception.NoMoneyException;
import com.zfb.wff.mapper.ExchangeMapper;
import com.zfb.wff.pojo.Exchange;
import com.zfb.wff.service.Service;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

	@Autowired
	Service service;
	
	@Autowired
	ExchangeMapper exchangeMapper;
	
	@GetMapping("/{from}/{to}/{money}")
	public Exchange zhuanzhang(@PathVariable long from,
											@PathVariable long to,
											@PathVariable BigDecimal money) {
		Exchange exchange = null;
		try {
			exchange = service.exchange(from, to, money);
		} catch (NoMoneyException e) {
			e.printStackTrace();
		}
		
		return exchange;
	}
	
	@GetMapping("/{id}")
	public List<Exchange> selectExchangeById(@PathVariable long id){
		return exchangeMapper.selectExchangeById(id);
	}
}
