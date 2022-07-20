package com.csmtech.service;

import java.util.List;

import com.csmtech.dao.EmpDao;
import com.csmtech.dao.EmpDaoImpl;
import com.csmtech.entity.Emp;


public class EmpServiceImpl implements EmpService {

//	@Override
//	public Long saveEmp(Emp emp) {
//		EmpDao empDao=new EmpDaoImpl();
//		Long id= empDao.saveEmp(emp);
//		return id;
//	}
	
	@Override
	public void saveEmp(Emp emp) {
		EmpDao empDao=new EmpDaoImpl();
		empDao.saveEmp(emp);
		
	}

	public List<Emp> getAllEmps() {
		
		return new EmpDaoImpl().getAllEmps();
	}

	public void deleteEmpById(Long eId) {
		new EmpDaoImpl().deleteEmpById(eId);

		
	}

	

}
