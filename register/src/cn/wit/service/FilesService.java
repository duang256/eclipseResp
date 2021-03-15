package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Files;
import cn.wit.pojo.Users;

public interface FilesService {
	List<Files> show();
	int updCount(int id,Users users,String name);
}
