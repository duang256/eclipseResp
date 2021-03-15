<!--
pageEncoding 和contentType是转java文件时所需要的编码格式设置,
在jsp转java文件的时候，先读pageEncoding，如果没有读到，会取contentType
而req.setCharacterEncoding、resp.setContentType分别是设置浏览器请求和响应的编码格式
  -->

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!--给资源前面添加项目路径  -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <style type="text/css">
  	a{
		color:black;
		text-decoration:none  	
  	}
  	a:hover{
  		color:red;
  	}
  
  </style>
  </head>
  
  <body>
    <table border='1px'>
    	<tr>
    		<th>花卉编号</th>
    		<th>花卉名称</th>
    		<th>价格</th>
    		<th>产地</th>
    	</tr>
    	
    	<c:forEach items="${list}" var="flower">
	    	<tr>
	    		<td>${flower.id}</td>
	    		<td>${flower.name}</td>
	    		<td>${flower.price}</td>
	    		<td>${flower.production}</td>
	    	</tr>
    	</c:forEach>
    	
    </table>
    <a href="add.jsp">添加花卉种类</a>
   </body>
  </html>
