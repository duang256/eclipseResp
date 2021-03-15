package cn.wit.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.wit.dao.FlowerDao;
import cn.wit.daoImpl.FlowerDaoImpl;
import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;
import cn.wit.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	Logger logger=Logger.getLogger(FlowerServiceImpl.class);
	@Override
	public PageInfo selByPage(String pageNumberStr,String pageSizeStr) {
		int pageNumber=1;
		int pageSize=3;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		logger.debug("pageNumber:"+pageNumber);
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		logger.debug("pageSize:"+pageSize);
		
		PageInfo pi=new PageInfo();
		FlowerDao fd=new FlowerDaoImpl();
		int count = fd.count();
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setPageSize(pageSize);
		pi.setStartNumber((pageNumber-1)*pageSize);
		pi.setPageNumber(pageNumber);
		logger.debug(pageNumber);
		pi.setList(fd.selByPage(pi));
		 
		return pi;
	}

}
