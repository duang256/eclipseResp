<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>花卉管理系统</title>
</head>


<body>
	<body>
	
	<h2>1.根据花名查找花卉数据</h2>
	<form action='main' method='post'>
	<input type="hidden" name="oper" value="select" />
		花名<input type="text" name='name' value='' >
		<br>
		<input type='submit' value='查询'>
	</form>
	<br><br>
	
	<h2>2.删除一条花卉数据</h2>
	<form action='main' method='post'>
	<input type="hidden" name="oper" value="delete" />
		花名<input type="text" name='name' value=''>
		<br>
		<input type='submit' value='删除'>
	</form>
	<br><br>
	
	<h2>3.增加一条花卉数据</h2>
	<form action='main' method='post'>
	<input type="hidden" name="oper" value="add" />
		花名<input type="text" name='name' value=''>
		<br>
		价格<input type="text" name='price' value=''>
		<br>
		产地<input type="text" name='production' value=''>
		<br>
		<input type='submit' value='添加'>
	</form>
	
	
	
	<h2>查看花卉总表</h2>
	<form action='page?pageSize=3&pageNumber=1' method='post'>
		<input type='submit' value='查看花卉总表' >
	</form>
	
				
</body>


</html>