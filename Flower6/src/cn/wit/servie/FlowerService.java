package cn.wit.servie;

import java.io.IOException;
import java.util.List;

import cn.wit.pojo.Flower;

public interface FlowerService {
	List<Flower> show()throws IOException;
}
