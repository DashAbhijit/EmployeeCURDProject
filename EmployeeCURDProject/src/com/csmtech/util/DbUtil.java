package com.csmtech.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.csmtech.entity.Dept;
import com.csmtech.entity.Emp;

public class DbUtil {

	private static Configuration cnf;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			cnf=	new Configuration();
			cnf.addAnnotatedClass(Emp.class);
			cnf.addAnnotatedClass(Dept.class);
			sessionFactory=cnf.buildSessionFactory();
		}
		return sessionFactory;
	}
}
