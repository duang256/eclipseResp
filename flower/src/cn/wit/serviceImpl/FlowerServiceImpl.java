package cn.wit.serviceImpl;

import java.util.List;

import cn.wit.dao.FlowerDao;
import cn.wit.dao.Impl.FlowerDaoImpl;
import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	FlowerDao flowerDao=new FlowerDaoImpl();

	@Override
	public List<Flower> show() {
		return flowerDao.selAll();
	}

	@Override
	public int add(Flower flower) {
		return flowerDao.insert(flower);
	}
}
