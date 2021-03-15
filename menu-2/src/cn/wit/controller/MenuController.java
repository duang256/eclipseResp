package cn.wit.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
	@RequestMapping("upload")
	public String demo(MultipartFile file) throws IOException{
		//获取文件名 有的浏览器文件名不带路径，有的浏览器文件名是全路径的
		String fileName = file.getOriginalFilename();
		//不获取文件的名字，只获取文件的后缀  subString是jdk String类中方法 包头不包尾
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uuid=UUID.randomUUID().toString();
		 FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));
		return "index";
	}
	
}
