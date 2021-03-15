package cn.wit.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Pointcut("execution(* cn.wit.test.Demo.Demo1())")
	public void Demo1(){
		System.out.println("demo1");
	}
	public void Demo2(){
		System.out.println("demo2");
	}
	public void Demo3(){
		System.out.println("demo3");
	}
	
}
