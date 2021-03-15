package cn.wit.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.ElementMapper;
import cn.wit.pojo.Element;
import cn.wit.service.ElementService;

@Service
public class ElementServiceImpl implements ElementService{
	
	@Resource
	private ElementMapper elementMapper;

	public List<Element> selByRid(int id) {
		return elementMapper.selByRid(id);
	}
	
	
}
