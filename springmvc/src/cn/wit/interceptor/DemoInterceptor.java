package cn.wit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	//�ڽ��������֮ǰִ��
	//�������ֵfalse ��ֹ����controller
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(arg2);
		System.out.println("preHandle");
		return true;
	}
	
	
	
	
	//controllerִ�����֮�󣬽��뵽jsp֮ǰִ��
	
	//��־��¼
	//��jsp������ʾ���û�֮ǰ���������д������
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//���д������
		String word=arg3.getModel().get("model").toString();
		String newWord=word.replace("����", "**");
		arg3.getModel().put("model", newWord);
		
		
		System.out.println("��ת��"+arg3.getViewName());
		//�õ�controller�в�����ֵ
		System.out.println("������ֵ"+arg3.getModel().get("model"));
		//�޸�controller�в�����ֵ
		System.out.println(arg3.getModel().put("model", "�޸ĺ��model"));
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		
	}
	
	
	//jspִ����֮��ִ��
	
	//�����쳣���ᱻ�ֻ���arg3��
	//��¼��ִ�й����г��ֵ��쳣
	//���԰��쳣��¼����־��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//�쳣�ռ�
		System.out.println("afterCompletion"+arg3.getMessage());
		
		System.out.println();
		System.out.println("afterCompletion");
		// TODO Auto-generated method stub
		
	}


}
