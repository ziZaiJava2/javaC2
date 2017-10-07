package com.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.store.model.Goods;

@Repository
public interface GoodsMapper {
	@Select("select * from goods god,category cate where god.category=cate.id")
	public List<Goods> selectAllGoods();

	@Select("select * from goods where name = #{goodsName} and category = #{category}; ")
	public List<Goods> selectGoods(@Param("goodsName") String goodsName, @Param("category") int category);
	
	@Select("select * from goods where name like #{name}")
	public List<Goods> selectGoodsCategory(@Param("name") String name);
	
	@Select("select * from goods where category like #{category}")
	public List<Goods> selectCategoryGoods(@Param("category") int category);

	@Insert("insert into category (name) values (#{name}) ")
	public void ceateCategory(@Param("name") String name);
	
	@Insert("insert into goods (name,category,date,price) values (#{name},#{category},#{date},#{price})")
	public void createGoods(@Param("name") String name,@Param("category") int category,@Param("date")String date,@Param("price")double price);
	
	@Delete("delete from goods where id = #{id}")
	public void deleteGoods(@Param("id")int id );
}
