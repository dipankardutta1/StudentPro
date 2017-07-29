package com.student.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.demo.pojo.Menu;
import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;
import com.student.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="userMng.html")
	public String goToUserMngScreen(Model model,HttpSession session){
		
		String username = (String) session.getAttribute("username");
		
		List<Menu> menuList = loginService.getMenusByUsername(username);
		
		model.addAttribute("menuList", menuList);
		
		
		List<User> userList = userService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		
		
		User user = new User();
		user.setName("Dipankar");
		
		model.addAttribute("user", user);
		
		
		
		return "userMng.jsp";
	}
	
	
	@RequestMapping(value="saveUser.html",method=RequestMethod.POST)
	public String saveUser(Model model,HttpSession session,@ModelAttribute("user") User user){
		
		if(user.getId() == null){
			userService.saveUser(user);
		}else{
			userService.updateUser(user);
		}
		
		
		
		
		String username = (String) session.getAttribute("username");
		
		List<Menu> menuList = loginService.getMenusByUsername(username);
		
		model.addAttribute("menuList", menuList);
		
		List<User> userList = userService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		
		
		model.addAttribute("user", user);
		
		return "userMng.jsp";
	}
	
	
	@RequestMapping(value="deleteUser.html")
	public String deleteUser(Model model,HttpSession session,@RequestParam("id") Integer id){
		userService.deleteUserById(id);
		
		
		String username = (String) session.getAttribute("username");
		
		List<Menu> menuList = loginService.getMenusByUsername(username);
		
		model.addAttribute("menuList", menuList);
		
		List<User> userList = userService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "userMng.jsp";
	}
	
	
	@RequestMapping(value="editUser.html")
	public String editUser(Model model,HttpSession session,@RequestParam("id") Integer id){
		
		
		
		String username = (String) session.getAttribute("username");
		
		List<Menu> menuList = loginService.getMenusByUsername(username);
		
		model.addAttribute("menuList", menuList);
		
		List<User> userList = userService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		User user = userService.findUserById(id);
		
		model.addAttribute("user", user);
		
		return "userMng.jsp";
	}
	
	
	

}
