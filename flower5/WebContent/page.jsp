<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" >
   		<tr>
   			<th>编号</th>
   			<th>花名</th>
   			<th>价格</th>
   			<th>产地</th>
   		</tr>
   		
   		<c:forEach items="${pi.list}" var="flower">
   			<tr>
   				<td>${flower.id}</td>
   				<td>${flower.name}</td>
   				<td>${flower.price}</td>
   				<td>${flower.production}</td>
   			</tr>
   		</c:forEach>
   	
   	</table>
   	<a href="page?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}" <c:if test="${pi.pageNumber<= 1}">         onclick="javascript:return false;"          </c:if>>上一页</a>
   	<a href="page?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}" <c:if test="${pi.pageNumber>= pi.total}">  onclick="javascript:return false;"          </c:if>>下一页</a>
</body>
</html>