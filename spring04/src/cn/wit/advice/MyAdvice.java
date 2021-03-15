package cn.wit.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Before("cn.wit.test.Demo.Demo1()")//ÌîÇÐµãµÄid
	public void mybefore(){
		System.out.println("Ç°ÖÃ");
	}
}
