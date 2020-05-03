package com.zfb.wff.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zfb.wff.pojo.User;

@Mapper
public interface UserMapper {

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@Select("select * from user")
	List<User> findAll();
	
	/**
	 * 查询指定用户的信息
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	User findById(long id);
	
	/**
	 * 查询指定用户的余额
	 * 
	 * @param id
	 * @return
	 */
	@Select("select money from user where id = #{id}")
	BigDecimal getMoneyById(long id);
	
	/**
	 * 更新指定用户的余额
	 * 
	 * @param id
	 * @param money
	 */
	@Update("update user set money = money + #{money} where id = #{id}")
	void setMoneyById(long id, BigDecimal money);
	
	/**
	 * 注册功能，添加新用户
	 * 
	 * @param user
	 */
	@Insert("insert into user(username,password,sex,phone) values(#{username},#{password},#{sex},#{phone})")
	void createUser(User user);
	
	/**
	 * 删除指定用户
	 * 
	 * @param id
	 */
	@Delete("delete from user where id = #{id}")
	void removeUserById(long id);
	
}
