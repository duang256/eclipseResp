<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var errori ='<%=request.getParameter("error")%>';
	if(errori=='yes'){
	 alert("账号或密码错误!");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post" >
	账号<input type="text" name="username"> <br>
	密码<input type="text" name="password"> <br>
	<input type="submit" value="登陆">
</form>
</body>

</html>