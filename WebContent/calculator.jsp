<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	input
	{
		width:50px;
		height:50px;
		margin:5px;
	}
</style>
<body>
	
	<form action="calculator" method="post">
		<%  %>
		<input type="button" name="value" value="7">
		<input type="button" name="value" value="8">
		<input type="button" name="value" value="9">
		<input type="submit" name="operator" value="x">
		<br>
		<input type="button" name="value" value="4">
		<input type="button" name="value" value="5">
		<input type="button" name="value" value="6">
		<input type="submit" name="operator" value="-">
		<br>
		<input type="button" name="value" value="1">
		<input type="button" name="value" value="2">
		<input type="button" name="value" value="3">
		<input type="submit" name="operator" value="+">
		<br>
		<input type="button" name="value" value="0">
		<input type="submit" name="operator" value="=">
	</form>
</body>
</html>