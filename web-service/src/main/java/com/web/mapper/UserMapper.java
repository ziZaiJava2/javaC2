package com.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import com.web.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository(value="userMapper")
public interface UserMapper {

	@Insert("insert into user(name, password, age) values(" +
			"#{name}, #{password}, #{age}")
	public int insertUser(User user);


}
