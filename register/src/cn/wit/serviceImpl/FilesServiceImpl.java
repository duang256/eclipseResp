package cn.wit.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.wit.mapper.FilesMapper;
import cn.wit.pojo.Files;
import cn.wit.pojo.Users;
import cn.wit.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService{
	@Resource
	private FilesMapper filesMapper;
	
	public List<Files> show() {
		return filesMapper.selAll();
	}
	
	public int updCount(int id,Users users,String name){
		Logger logger=Logger.getLogger(FilesServiceImpl.class);
		logger.info(users.getUsername()+"œ¬‘ÿ¡À"+name);
		return filesMapper.updCountById(id);
	}

}
