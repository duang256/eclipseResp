package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Url;

public interface UrlService {
	List<Url>selByRid(int rid);
	List<Url>showAll();
}
