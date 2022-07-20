package com.csmtech.service;

import java.util.List;

import com.csmtech.entity.Emp;

public interface EmpService {
	
	void saveEmp(Emp emp);

	 List<Emp> getAllEmps();
	 void deleteEmpById(Long eId);
}
