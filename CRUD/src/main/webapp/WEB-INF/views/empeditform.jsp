<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="../editsave">
		<table>
			<tr>
				<td>ID :</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><form:input path="department" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Position :</td>
				<td><form:input path="position" /></td>
			</tr>
			<tr>
				<td>IP :</td>
				<td><form:input path="ip" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" response.sendRedirect("viewemp.jsp");/></td> 
			</tr>
		</table>
		
	</form:form>
</body>
</html>