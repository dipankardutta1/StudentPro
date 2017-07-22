package com.student.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.pojo.RoleMenuMapping;
import com.student.demo.pojo.UserRoleMapping;

@Repository
public class RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<UserRoleMapping> findRoleIdsByUserId(Integer userId) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from UserRoleMapping where user.id = :param");
			query.setParameter("param", userId);
			
			List<UserRoleMapping> list =  query.list();
			
			
			return list;
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
		
		
		
	}

	public List<RoleMenuMapping> findMenusByRoleId(Integer roleId) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from RoleMenuMapping where role.id = :param");
			query.setParameter("param", roleId);
			
			List<RoleMenuMapping> list =  query.list();
			
			
			return list;
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}
	
	
	
	

}
