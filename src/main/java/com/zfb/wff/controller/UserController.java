package com.zfb.wff.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfb.wff.mapper.UserMapper;
import com.zfb.wff.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper userMapper;

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@GetMapping
	List<User> findAll(){
		return userMapper.findAll();
	}
	
	/**
	 * 查询指定用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	User findById(@PathVariable long id) {
		return userMapper.findById(id);
	}
	
	/**
	 * 查询指定用户的余额
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/money")
	BigDecimal getMoneyById(@PathVariable long id) {
		return userMapper.getMoneyById(id);
	}
	
	/**
	 * 指定用户充值余额
	 * 
	 * @param id
	 * @param money
	 * @return
	 */
	@GetMapping("/{id}/add/{money}")
	ResponseEntity<String> addMoneyById(@PathVariable long id, @PathVariable BigDecimal money) {
		userMapper.setMoneyById(id, money);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * 注册新用户
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	ResponseEntity<String> createUser(@RequestBody User user) {
		userMapper.createUser(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * 删除指定用户
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	ResponseEntity<String> removeUserById(@PathVariable long id){
		userMapper.removeUserById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
