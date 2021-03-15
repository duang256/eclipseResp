<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			//parent表示父标签  prev表示前一个兄弟标签
			var $td=$(this).parent().prev();		
			//获取td里边的字符串
			$td.html(parseInt($td.html())+1);
		});
	});
</script>
</head>
<body>

<table border="1px">
	<tr>
		<th>资料名称</th>
		<th>下载次数</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list }" var="file">
		<tr>
			<td>${file.name }</td>
			<td>${file.count }</td>
			<!--点击下载以后，需要将下载次数更新加1，update，
			并且通过name完成下载操作  -->
			<td><a href="download?id=${file.id}&name=${file.name}">下载</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>