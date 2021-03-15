package cn.wit.service;

import java.io.IOException;
import java.util.List;

import cn.wit.pojo.Car;
import cn.wit.pojo.Users;

public interface LoginService {
	Users login(Users users)throws IOException;
	List<Car> getCars(Users users)throws IOException;
}
