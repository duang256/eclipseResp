package cn.wit.pojo;

import net.sf.cglib.proxy.Enhancer;

public interface Visitor {
	public static void main(String[] args) {
		Enhancer enhancer=new Enhancer();
		//���ø���
		enhancer.setSuperclass(Boss.class);
		//���봦�����
		enhancer.setCallback(new Secretary());
		//�������ࣨ��̬��
		Boss boss = (Boss) enhancer.create();
		boss.makeDecision();
	}
}
