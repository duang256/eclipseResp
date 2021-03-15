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
		//文件名
		String fileName = file.getOriginalFilename();
		//随机文件名 文件后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		
		//获取某个文件夹完整路径
		String path=req.getServletContext().getRealPath("images")+"\\"+uuid+suffix;
		//将文件流copy到新建的文件中
		System.out.println(path);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//仅仅把文件名存到数据库中，而且没有传全路径
		//如果传全路径，在下载文件的时候是没有权限访问到服务器之外的内容的
		//所以一般把文件放到特定的项目文件夹里边，使得通过文件名就可以拿到文件
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