package com.web.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.web.entity.User;

//有mapper.java就可以不用mapper.xml文件了，两者作用相同，这个是.java的写法
@Repository(value = "userMapper")
public interface UserMapper {

	// 注解的作用就是告诉mybatis框架,执行括号内的sql语句
	@Insert("insert into user(name, password, age) values(" + "#{user.name}, #{user.password}, #{user.age})")
	public int insertUser(@Param("user") User user);// 因为不用xml配置文件,那么我们就要用别的方式来给参数命名,这个方式就是@Param注解

	@Delete("delete from user where id = #{id}")
	public int deleteUser(@Param("id") int id);
	
	@Update("update user set passoword = #{password} where id = #{id}")
	public int updateUser(int id,String password);
	
	@Select("select * from user where id = #{id}")
	public User selectUser(@Param("id")int id);
}
