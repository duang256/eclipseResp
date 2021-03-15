package cn.wit.advice;


public class MyThrowAdvice {
	public void MyThrow(Exception e) {
		System.out.println("throw Exception"+e.getMessage());
	}
}
