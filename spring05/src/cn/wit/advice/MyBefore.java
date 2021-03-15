package cn.wit.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import cn.wit.pojo.Users;

public class MyBefore implements MethodBeforeAdvice{
	/*- arg0 切点方法
	- arg1方法名
	- arg3方法所在对象*/
	
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		Users users=(Users)arg1[0];
		Logger logger=Logger.getLogger(MyBefore.class);
		logger.info(users.getUserName()+"在"+new Date().toLocaleString()+"进行了登录");
	}

}
 