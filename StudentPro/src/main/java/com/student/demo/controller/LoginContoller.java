package com.student.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.demo.pojo.Menu;
import com.student.demo.service.LoginService;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
	public String goToLoginPage(){
				
		
		return "login.jsp";
	}
	
	
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST )
	public String validateUser(Model model,HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password){
		
		
		session.setAttribute("isLoggedIn", "yes");
		
		Boolean status = loginService.isValidUser(username, password);
		
		
		
		
		
		if(status){
			
			session.setAttribute("username", username);
			
			
			List<Menu> menuList = loginService.getMenusByUsername(username);
			
			model.addAttribute("menuList", menuList);
			
			
			
			
			
			
			return "dashboard.jsp";
		}else{
			return "login.jsp";
		}
		
		
		
	}
	
	
	@RequestMapping(value="logout.html")
	public String logout(Model model,HttpSession session){
		
		
		
		session.invalidate();
		
		
		return "login.jsp";
		
		
		
		
		
		
	}
	
	
	
	
	

}
