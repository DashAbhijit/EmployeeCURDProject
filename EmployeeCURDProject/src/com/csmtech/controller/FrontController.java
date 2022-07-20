package com.csmtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.csmtech.entity.Dept;
import com.csmtech.entity.Emp;
import com.csmtech.service.EmpServiceImpl;
import com.csmtech.util.DbUtil;

public class FrontController extends HttpServlet {

	
	private Session session;
	private Query query;
	
	@Override
	public void init() throws ServletException {
		
		session=DbUtil.getSessionFactory().openSession();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		if(req.getServletPath().equals("/getEmpForm")) {
			query=session.createQuery("from Dept");
			List<Dept> deptList=query.list();
			req.setAttribute("deptList",deptList );
			req.setAttribute("empList", new EmpServiceImpl().getAllEmps());
			req.getRequestDispatcher("Empform.jsp").forward(req, resp);
		}	
	}
	@Override
	public void destroy() {
		session.close();
	}
}
