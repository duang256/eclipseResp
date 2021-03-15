<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加花卉信息</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("form").submit(function(){
			//表单选择器   :input标签type属性值     
			if($(":text:eq(0)").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()==""){
				alert("信息不能为空");
				return false;
			}
		});
	});
</script>

</head>
<body>
	<form action="add" method="get"  >
		<table border="1px" align="center">
			<tr>
				<td colspan="2" style="text-align:center; font-size:30px;font-weight:bold">
					花卉信息
				</td>
			</tr>
			<tr>
				<td>花卉名称</td>
				<td>
					<input type="text" name="name" value="">
				</td>
			</tr>
			<tr>
				<td>花卉价格</td>
				<td>
					<input type="text" name="price" value="">
				</td>
			</tr>
			<tr>
				<td>花卉产地</td>
				<td>
					<input type="text" name="production" value="">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交"><input type="reset" value="重置">
				</td>
			</tr>
		
		
		</table>
	
	
	</form>
</body>
</html>