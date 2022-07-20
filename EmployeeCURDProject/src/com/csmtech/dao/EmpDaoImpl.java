package com.csmtech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.csmtech.entity.Emp;
import com.csmtech.util.DbUtil;

public class EmpDaoImpl implements EmpDao {

	private Session session=null;
	private  Query query=null;
//	@Override
//	public Long saveEmp(Emp emp) {
//		
//		session=DbUtil.getSessionFactory().openSession();
//		Long genEmpId=null;
//		Transaction tx= session.beginTransaction();
//			genEmpId=(Long)session.save(emp);
//		tx.commit();
//		session.close();
//		return genEmpId;	
//	}
	
	@Override
	public void saveEmp(Emp emp) {
		
		session=DbUtil.getSessionFactory().openSession();
		//Long genEmpId=null;
		Transaction tx= session.beginTransaction();
			session.saveOrUpdate(emp);;
		tx.commit();
		session.close();
		
	}
	
	public List<Emp> getAllEmps() {
		
		session=DbUtil.getSessionFactory().openSession();
		query=session.createQuery("from Emp where is_delete='NO'");
		List<Emp> empList=query.list();
		session.close();
		return empList;
	}
	public void deleteEmpById(Long eId) {

		session=DbUtil.getSessionFactory().openSession();
		Emp emp=session.get(Emp.class, eId);
		emp.setIsDelete("YES");
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(emp);
		tx.commit();
		session.close();
		
	}

}
