package cn.wit.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wit.pojo.Users;
import cn.wit.service.FilesService;

@Controller
public class FilesController {
	@Resource
	private FilesService filesSerivceImpl;
	
	@RequestMapping("show")
	public String show(Model model){
		model.addAttribute("list",filesSerivceImpl.show());
		return "/main.jsp";
	}
	@RequestMapping("download")
	public void download(int id,String name,HttpServletResponse res,HttpServletRequest req) throws IOException{
		filesSerivceImpl.updCount(id,(Users)req.getSession().getAttribute("users"),name);
		res.setHeader("content-Disposition", "attachment;filename="+name);
		File file = new File(req.getServletContext().getRealPath("files"),name);
		byte[] bytes;
			bytes = FileUtils.readFileToByteArray(file);
			ServletOutputStream os = res. getOutputStream();
			os.write(bytes);
			os.flush();
			os.close();
	}
	
}
