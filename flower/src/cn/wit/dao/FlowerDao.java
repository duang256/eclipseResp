package cn.wit.dao;

import java.util.List;

import cn.wit.pojo.Flower;

public interface FlowerDao {
    List<Flower> selAll();

	int insert(Flower flower);

}
