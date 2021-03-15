package cn.wit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;

public interface FlowerService {
	List<Flower> sel(String name);
	void addOne(String name, double price, String production);
	void delOne(String name);
	PageInfo showPage (int pageSize, int pageNumber);
}
