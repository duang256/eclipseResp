package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Car;
import cn.wit.pojo.Users;

public interface LoginService {
	Users login(Users users);
	List<Car> getCars(int rid);
}
