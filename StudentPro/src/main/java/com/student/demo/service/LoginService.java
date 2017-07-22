package com.student.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.dao.MenuDao;
import com.student.demo.dao.RoleDao;
import com.student.demo.dao.UserDao;
import com.student.demo.pojo.Menu;
import com.student.demo.pojo.RoleMenuMapping;
import com.student.demo.pojo.User;
import com.student.demo.pojo.UserRoleMapping;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	
	
	public Boolean isValidUser(String username,String password){
		
		
		User user = userDao.findByUsernameAndPassword(username, password);
		
		if(user == null){
			return false;
		}else{
			return true;
		}
		
	}


	public List<Menu> getMenusByUsername(String username) {
		
		User user = userDao.findUserByUsername(username);
		
		
		List<UserRoleMapping> roles = roleDao.findRoleIdsByUserId(user.getId());
		
		List<Menu> menus = new ArrayList<Menu>();
		
		for(UserRoleMapping userRoleMapping : roles){
			
			List<RoleMenuMapping> roleMenuMappings = roleDao.findMenusByRoleId(userRoleMapping.getRole().getId());
			
			
			for(RoleMenuMapping roleMenuMapping : roleMenuMappings){
				
				
				Menu menu = menuDao.findById(roleMenuMapping.getMenu().getId());
				
				menus.add(menu);
				
			}
			
			
		}
		
		
		
		
		return menus;
		
		
		
	}
	
	

}
