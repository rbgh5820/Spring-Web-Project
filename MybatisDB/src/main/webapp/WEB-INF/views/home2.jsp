<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB 조회하기</title>
</head>
<body>
 <h2>DB 테이블 조회하기</h2>
 <table border=1>
  <thead>
   <tr>
     <td>아이디</td>
     <td>이름</td>
     <td>이메일</td>
     <td>전화번호</td>
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