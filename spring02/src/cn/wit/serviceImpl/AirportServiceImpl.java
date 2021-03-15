package cn.wit.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wit.mapper.AirportMapper;
import cn.wit.pojo.Airport;
import cn.wit.service.AirportService;

public class AirportServiceImpl implements AirportService{
	private AirportMapper airportMapper ;
	
	

	public AirportMapper getAirportMapper() {
		return airportMapper;
	}



	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}



	@Override
	public List<Airport> selAll() {
		return airportMapper.selAll();
	}
	

}
