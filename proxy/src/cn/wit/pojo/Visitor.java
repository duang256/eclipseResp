package cn.wit.pojo;

import net.sf.cglib.proxy.Enhancer;

public interface Visitor {
	public static void main(String[] args) {
		Enhancer enhancer=new Enhancer();
		//设置父类
		enhancer.setSuperclass(Boss.class);
		//传入处理对象
		enhancer.setCallback(new Secretary());
		//返回子类（多态）
		Boss boss = (Boss) enhancer.create();
		boss.makeDecision();
	}
}
