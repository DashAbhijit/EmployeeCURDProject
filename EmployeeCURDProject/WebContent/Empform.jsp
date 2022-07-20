<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>Employee Registration Form</h3>
		<Form method="post" action="./saveEmp">
		<input type="hidden" name="empId" value="${uemp.empId}">
			<div>
				<label>Employee Name::</label>
				<input type="text" name="empName" value="${uemp.empName}">
			</div>
			<div>
				<label>Salary::</label>
				<input type="text" name="sal" value="${uemp.salary}">
			</div>
			<div>
				<label>HireDate::</label>
				<input type="text" name="hdate" value="<fmt:formatDate pattern="yyyy/MM/dd" type="date" value="${uemp.hireDate}" />">
			</div>
			<div>
				<label>DeptId::</label>
				<select name="empDeptId">
					<option value="0">--Select--</option>
					<c:forEach var="dept" items="${deptList}">
						<option value="${dept.deptId}" <c:if test="${dept.deptId eq uemp.deptId }"> selected="selected"</c:if>>${dept.deptName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<c:if test="${uemp eq null }">
				<input type="submit" value="Save"></c:if>
				<c:if test="${uemp ne null }">
				<input type="submit" value="Update"></c:if>
			</div>
			
		</Form>
		
		<h4>Employee Details</h4>
		<table border="1">
			<thead>
				<tr>
					<th>Sl.No</th>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>salary</th>
					<th>HireDate</th>
					<th>DeptId</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="emp" varStatus="count">
					<tr>
						<td>${count.count}</td>
						<td>${emp.empId }</td>
						<td>${emp.empName }</td>
						<td>${emp.salary }</td>
						
						<td><fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${emp.hireDate}" /></td>
						<td>${emp.deptId }</td>
						<td><a href="./updateEmp?empId=${emp.empId}">Update</a>&nbsp;&nbsp;<a href="./deleteEmp?empId=${emp.empId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>