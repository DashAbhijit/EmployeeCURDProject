package com.csmtech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emp implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;
	@Column(name="emp_name")
	private String empName;
	private Double salary;
	@Column(name="hire_date")
	private Date hireDate;
	@Column(name="dept_id")
	private Long deptId;
	@Column(name="is_delete")
	private String isDelete;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", hireDate=" + hireDate
				+ ", deptId=" + deptId + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
	
}
