package cn.wit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wit.pojo.Flower;

public interface FlowerMapper {
	List<Flower> sel(@Param("name")String name);
	int addOne(@Param("name")String name,@Param("price") double price,@Param("production") String production);
	int delOne(@Param("name")String name);
	List<Flower> selByPage(@Param("pageStart") int pageStart,@Param("pageSize")int pageSize);
	int selCount();
}
