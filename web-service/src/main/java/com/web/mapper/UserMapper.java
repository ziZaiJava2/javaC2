package com.web.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.web.entity.User;

//��mapper.java�Ϳ��Բ���mapper.xml�ļ��ˣ�����������ͬ�������.java��д��
@Repository(value = "userMapper")
public interface UserMapper {

	// ע������þ��Ǹ���mybatis���,ִ�������ڵ�sql���
	@Insert("insert into user(name, password, age) values(" + "#{user.name}, #{user.password}, #{user.age})")
	public int insertUser(@Param("user") User user);// ��Ϊ����xml�����ļ�,��ô���Ǿ�Ҫ�ñ�ķ�ʽ������������,�����ʽ����@Paramע��

	@Delete("delete from user where id = #{id}")
	public int deleteUser(@Param("id") int id);
	
	@Update("update user set passoword = #{password} where id = #{id}")
	public int updateUser(int id,String password);
	
	@Select("select * from user where id = #{id}")
	public User selectUser(@Param("id")int id);
}
