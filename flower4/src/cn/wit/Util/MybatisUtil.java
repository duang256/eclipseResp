package cn.wit.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//factory实例化的过程是一个比较耗费性能的过程
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<>();
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory= new SqlSessionFactoryBuilder().build(is);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static SqlSession getSession(){
		SqlSession session = tl.get();//此处第一次取为null
		if(session==null){
			tl.set(factory.openSession());
		}
		return tl.get();
	}
	public static void closeSession(){
		SqlSession session=tl.get();
		if(session!=null){
			session.close();
		}
		tl.set(null);
	}
}
