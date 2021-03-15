package cn.wit.service;
import java.util.List;

import cn.wit.pojo.Flower;

public interface FlowerService {
	List <Flower> show();
	int add(Flower flower);
}
