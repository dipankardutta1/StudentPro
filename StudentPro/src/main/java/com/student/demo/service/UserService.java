package com.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public List<User> findAllUsers(){
		
		
		return userDao.findAll();
		
	}


	public void saveUser(User user) {
		userDao.save(user);
		
	}


	public void deleteUserById(Integer id) {
		userDao.deleteById(id);
		
	}


	public User findUserById(Integer id) {
		return userDao.findById(id);
	}


	public void updateUser(User user) {
		userDao.update(user);
		
	}

}
