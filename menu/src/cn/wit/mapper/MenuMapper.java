package cn.wit.mapper;

import java.util.List;

import cn.wit.pojo.Menu;

public interface MenuMapper {
	List<Menu>selByPid(int pid);
}
