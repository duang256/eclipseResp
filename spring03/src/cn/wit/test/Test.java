package cn.wit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = ac.getBean("demo",Demo.class);
		try {
			demo.Demo2();
		} catch (Exception e) {
		} 
	}
}
