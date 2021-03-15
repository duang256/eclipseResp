package cn.wit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.wit.pojo.Airport;

public interface AirportMapper {
	@Select("select *from airport")
	List<Airport> selAll();
}
