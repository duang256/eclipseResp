package cn.wit.dao;

import java.util.List;

import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;

public interface FlowerDao {
	int count();
	List<Flower> selByPage(PageInfo pi);
	
}
