package cn.wit.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.UrlMapper;
import cn.wit.pojo.Url;
import cn.wit.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService{
	
	@Resource
	private UrlMapper urlMapper;
	@Override
	public List<Url> selByRid(int rid) {
		return urlMapper.selByRid(rid);
	}
	@Override
	public List<Url> showAll() {
		return urlMapper.selAll();
	}

}
