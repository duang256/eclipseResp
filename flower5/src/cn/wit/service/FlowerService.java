package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;

public interface FlowerService {
	PageInfo  selByPage(String pageNumber,String pageSizeStr);
}
