package cn.wit.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wit.mapper.AirportMapper;
import cn.wit.pojo.Airport;
import cn.wit.service.AirportService;
import cn.wit.util.MyBatisUtil;

public class AirportServiceImpl implements AirportService{

	@Override
	public List<Airport> showTakeport() {
		SqlSession session = MyBatisUtil.getSession();
		AirportMapper mapper = session.getMapper(AirportMapper.class);
		List<Airport> list = mapper.selTakePort();
		return list;
	}
	
}
