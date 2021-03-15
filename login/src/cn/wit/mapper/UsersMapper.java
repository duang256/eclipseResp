package cn.wit.mapper;

import org.apache.ibatis.annotations.Select;

import cn.wit.pojo.Users;

public interface UsersMapper {
	@Select("select *from users where username=#{userName} and password=#{passWord}")
	Users selOne(Users u);
}
