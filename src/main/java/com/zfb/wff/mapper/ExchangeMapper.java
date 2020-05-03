package com.zfb.wff.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zfb.wff.pojo.Exchange;

@Mapper
public interface ExchangeMapper {

	/**
	 * 创建交易记录，可获得交易记录的编号
	 * 
	 * @param exchange	交易的基本信息
	 * @return
	 */
	@Insert("insert into exchange(`from`,`to`,`money`) values(#{from},#{to},#{money})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	boolean create(Exchange exchange);
	
	/**
	 * 交易状态更新为成功（事务提交）
	 * 
	 * @param id
	 */
	@Update("update exchange set status='T' where id = #{id}")
	void updateStatusTrue(long id);

	/**
	 * 查询与指定id用户有关的订单
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from exchange where `from` = #{id} or `to` = #{id}")
	List<Exchange> selectExchangeById(long id);
}
