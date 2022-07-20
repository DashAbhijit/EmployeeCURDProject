package com.csmtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmtech.entity.Emp;
import com.csmtech.service.EmpService;
import com.csmtech.service.EmpServiceImpl;

public class SaveEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		Emp emp=new Emp();
		if(!req.getParameter("empId").equals(""))
			emp.setEmpId(Long.parseLong(req.getParameter("empId")));
		emp.setEmpName(req.getParameter("empName"));
		emp.setSalary(Double.parseDouble(req.getParameter("sal")));
		try {
			emp.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse( req.getParameter("hdate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emp.setDeptId(Long.parseLong(req.getParameter("empDeptId")));
		emp.setIsDelete("NO");
		
		EmpService empService=new EmpServiceImpl();
		empService.saveEmp(emp);
		//Long empId=empService.saveEmp(emp);
		resp.sendRedirect("./getEmpForm");
		
		//pw.println(" Record saved in EmployeeId of:: "+empId);
		
	}
}
