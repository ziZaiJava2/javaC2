package com.store.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.store.model.Shopping;
import com.store.model.User;

import java.util.List;

@Repository
public interface ShoppingMapper {
	@Insert("insert into shopping (goodsName,userName,price) values (#{goodsName},#{userName},#{price})")
	public void shopping(@Param("goodsName")String goodsName,@Param("userName")String userName,@Param("price")double pricee);
	
	@Select("select * from shopping where userName = #{name}")
	public List<Shopping> selectShopping(@Param("name") String name);

	@Select("select count(*) as value from shopping where userName = #{name};")
	public int getNum(@Param("name") String name);

	@Select("select sum(price) from shopping where userName = #{name};")
	public double total(@Param("name") String name);

	@Delete("delete from shopping where id = #{id}")
	public void delShopping(@Param("id") int id);
}
