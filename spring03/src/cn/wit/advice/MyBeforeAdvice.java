package cn.wit.advice;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("�е㷽������"+arg1);
		System.out.println("������"+arg0.getName());
//		System.out.println("�е㷽������"+arg1[0]);
		System.out.println("�������ڶ���"+arg2);
		
		System.out.println("����ǰ��֪ͨ");
	}
	
}
