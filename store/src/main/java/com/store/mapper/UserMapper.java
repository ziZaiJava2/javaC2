package com.store.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.store.model.User;

@Repository
public interface UserMapper {
	
	@Select("select * from user where name = #{name} and password = #{password}")
	public User selectUser(@Param("name") String name, @Param("password") String password);
	
	@Insert("insert into user (name,sex,password) values (#{name},#{sex},#{password})")
	public void createUser(@Param("name") String name, @Param("sex") String sex,@Param("password") String password);
}
