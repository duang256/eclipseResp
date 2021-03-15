package cn.wit.mapper;

import org.apache.ibatis.annotations.Select;

import cn.wit.pojo.User;

public interface LoginMapper {
	@Select("select *from user where username=#{username} and password=#{password}")
	User selByUser(User user);
}
