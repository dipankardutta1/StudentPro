package com.student.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.pojo.Menu;
import com.student.demo.pojo.RoleMenuMapping;

@Repository
public class MenuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Menu findById(Integer id) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Menu menu = (Menu) session.get(Menu.class, id);
			
			
			return menu;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}
	
	
	
	
	

}
