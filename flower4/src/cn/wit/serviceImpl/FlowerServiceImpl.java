package cn.wit.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.wit.Util.MybatisUtil;
import cn.wit.mapper.FlowerMapper;
import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;
import cn.wit.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	
	public PageInfo showPage(int pageSize, int pageNumber) {
		SqlSession session = MybatisUtil.getSession();
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		//map
		Map<String,Object> map =new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("cn.wit.mapper.FlowerMapper.selByPage",map));
		
		int count = session.selectOne("cn.wit.mapper.FlowerMapper.selCount");
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

	@Override
	public List<Flower> sel(String name) {
		//当mybatis接口绑定之后，service与mapper层互动的方式也变化的了
		SqlSession session = MybatisUtil.getSession();
		FlowerMapper mapper=session.getMapper(FlowerMapper.class);
		List<Flower> list = mapper.sel(name);
		return list;
	}

	@Override
	public void addOne(String name, double price, String production) {
		SqlSession session = MybatisUtil.getSession();
		FlowerMapper mapper = session.getMapper(FlowerMapper.class);
		mapper.addOne(name, price, production);
	}

	@Override
	public void delOne(String name) {
		SqlSession session = MybatisUtil.getSession();
		FlowerMapper mapper = session.getMapper(FlowerMapper.class);
		mapper.delOne(name);
	}
	
	
}
