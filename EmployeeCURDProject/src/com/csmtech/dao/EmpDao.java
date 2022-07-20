package com.csmtech.dao;

import java.util.List;

import com.csmtech.entity.Emp;

public interface EmpDao {
	
	void saveEmp(Emp emp);

	List<Emp> getAllEmps();
	void deleteEmpById(Long eId);

}
