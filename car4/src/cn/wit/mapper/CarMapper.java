package cn.wit.mapper;

import java.util.List;

import cn.wit.pojo.Car;

public interface CarMapper {
	List<Car> selCar(int rid);
}
