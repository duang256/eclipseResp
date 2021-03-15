package cn.wit.mapper;

import java.util.List;

import cn.wit.pojo.Car;
import cn.wit.pojo.Users;

public interface CarMapper {
	List<Car> selCar(Users users);
}
