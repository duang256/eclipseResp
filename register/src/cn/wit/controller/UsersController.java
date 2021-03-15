package cn.wit.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.wit.pojo.Users;
import cn.wit.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	@RequestMapping("register")
	public String register(Users users,MultipartFile file,HttpServletRequest req) {
		//�ļ���
		String fileName = file.getOriginalFilename();
		//����ļ��� �ļ���׺
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		
		//��ȡĳ���ļ�������·��
		String path=req.getServletContext().getRealPath("images")+"\\"+uuid+suffix;
		//���ļ���copy���½����ļ���
		System.out.println(path);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�������ļ����浽���ݿ��У�����û�д�ȫ·��
		//�����ȫ·�����������ļ���ʱ����û��Ȩ�޷��ʵ�������֮������ݵ�
		//����һ����ļ��ŵ��ض�����Ŀ�ļ�����ߣ�ʹ��ͨ���ļ����Ϳ����õ��ļ�
		users.setPhoto(uuid+suffix);
		int index = usersServiceImpl.insRegister(users);
		if(index>0){
			HttpSession session = req.getSession();
			session.setAttribute("users", users);
			return "redirect:/show";
		}else{
			return "redirect:/register.jsp";
		}
	}
}