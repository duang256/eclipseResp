package cn.wit.mapper;

import org.apache.ibatis.annotations.Select;

import cn.wit.pojo.Car;

public interface CarMapper {
	@Select("select *from car where name=#{name}")
	Car selCar(Car car);
}
