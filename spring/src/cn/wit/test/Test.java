package cn.wit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wit.pojo.People;

public class Test {
	public static void main(String[] args) {
//		People p=new People();
		//º”‘ÿ≈‰÷√Œƒº˛ 
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		 People peo = ac.getBean("peo",People.class);
		 System.out.println(peo);
	}
}
