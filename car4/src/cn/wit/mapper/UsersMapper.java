package cn.wit.mapper;

import org.apache.ibatis.annotations.Select;

import cn.wit.pojo.Users;

public interface UsersMapper {
	@Select("select *from users where username=#{username} and password=#{password}")
	Users selUsers(Users users);
}
