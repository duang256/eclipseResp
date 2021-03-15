<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>花卉信息</title>
<script type="text/javascript"></script>

</head>
<body>
	<table border='1px'>
		
		<tr>
			<th>花卉编号</th>		
			<th>名称</th>
			<th>价格</th>
			<th>产地</th>
		</tr>
		<c:forEach items="${list}" var="flower">
			<tr>
				<td>${flower.id }</td>
				<td>${flower.name }</td>
				<td>${flower.price }</td>
				<td>${flower.production }</td>			
			</tr>
		</c:forEach>
		
	
	
	</table>





</body>
</html>