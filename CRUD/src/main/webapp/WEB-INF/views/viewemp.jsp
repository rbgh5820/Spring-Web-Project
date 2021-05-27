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
 <h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
    <tr>
        <th>Id</th>
        <th>Department</th>
        <th>Name</th>
        <th>Position</th>
        <th>IP</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>  
    <c:forEach var="co" items="${list}">   
        <tr>  
            <td>${co.id}</td>  
            <td>${co.department}</td>  
            <td>${co.name}</td>
            <td>${co.position}</td>
            <td>${co.ip}</td>
            <td>${co.phone}</td>
            <td>${co.email}</td>   
            <td><a href="editemp/${co.id}">Edit</a></td>  
            <td><a href="deleteemp/${co.id}">Delete</a></td>  
        </tr>
   </c:forEach>  
</table>  
<br/>  
<a href="empform">Add New Employee</a>  
</body>
</html>