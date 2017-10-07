package com.store.mapper;

import java.util.List;

import com.store.model.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.store.model.Goods;

@Repository
public interface CategoryMapper {
	@Select("select name from category where id = #{id}")
	public String selectCategoryName(@Param("id") int id);
	
	@Select("select id from category where name = #{name}")
	public int selectCategoryId(@Param("name") String name);

	@Select("select * from category")
	public List<Category> selectAllCategoryName();
}
