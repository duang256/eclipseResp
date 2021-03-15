package cn.wit.mapper;

import java.util.List;


import cn.wit.pojo.Element;

public interface ElementMapper {
	List<Element> selByRid(int id);
}
