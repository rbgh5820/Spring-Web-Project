<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB ��ȸ�ϱ�</title>
</head>
<body>
 <h2>DB ���̺� ��ȸ�ϱ�</h2>
 <table border=1>
  <thead>
   <tr>
     <td>���̵�</td>
     <td>�̸�</td>
     <td>�̸���</td>
     <td>��ȭ��ȣ</td>
   </tr>
  </thead>
  <tbody>
   <c:forEach items="${userList}" var="user">
    <tr>
     <td>${user.userid}</td>
     <td>${user.username}</td>
     <td>${user.email}</td>
     <td>${user.phone}</td>
    </tr>
   </c:forEach>
  </tbody>
 </table>
</body>
</html>