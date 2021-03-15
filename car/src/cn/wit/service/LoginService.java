package cn.wit.service;

import java.io.IOException;

import cn.wit.pojo.Car;

public interface LoginService {
	Car login(Car car)throws IOException;
}
