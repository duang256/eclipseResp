package cn.wit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController{
	@RequestMapping("demo")
	public String demo(Model model){
		model.addAttribute("model", "model��ֵ"); 
		System.out.println("ִ��demo");
		return "/index.jsp";
	}
}
