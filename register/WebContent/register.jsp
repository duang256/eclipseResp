<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function(){
		var username=false;
		var password=false;
		var passwordSure=false;
		//用户名的验证
		$(":text:eq(0)").blur(function(){
			if($(this).val()==""){
				$(this).next().css("color","red").html("×");
				usernaem=false;
			}else{
				$(this).next().css("color","green").html("√");
				username=true;
			}
		});
		//密码验证
		$(":password:eq(0)").blur(function(){
			//\w表示数字字母下划线   只有在js中正则表达式必须包含在//中 
			// jdk pattern中能找到正则的各种表示
			if($(this).val().match(/^\w{6,12}$/)){
				$(this).next().css("color","green").html("√");
				password=true;
			}else{
				$(this).next().css("color","red").html("×");
				password=false;
			}
		});
		//确认密码
		$(":password:eq(1)").blur(function(){
			if($(this).val()==""||$(this).val()!=$(":password:eq(0)").val()){
				$(this).next().css("color","red").html("×");
				passwordSure=false;
			}else{
				$(this).next().css("color","green").html("√");
				passwordSure=true;
			}
		});
		
		//文件筐不允许被设置内容     是只读的
		$(":submit").click(function(){
			if(username==false||password==false||passwordSure==false||$(":file").val()==""){
				alert("请填写完整信息");
				return false;
			}
		});
		
		
	});
</script>
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
	用户名：<input type="text" name="username"><span></span><br>
	密码：<input type="password" name="password"><span></span><br>
	确认密码：<input type="password" name="passwordSure"><span></span><br>
	头像：<input type="file" name="file"><br>
	<input type="submit" value="注册"><br>
	
</form>
</body>
</html>