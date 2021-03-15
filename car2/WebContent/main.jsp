<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
	<tr>
		<th>名字</th>
		<th>价格</th>
		<th>宣传语</th>
	</tr>
	<c:forEach items="${cars}" var="car">
		<tr>
			<td>${car.name }</td>
			<td>${car.price }</td>
			<td>${car.slogan }</td>
		</tr>
	</c:forEach>
	

</table>
</body>
</html>