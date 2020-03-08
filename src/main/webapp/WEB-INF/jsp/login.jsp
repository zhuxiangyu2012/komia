<html>
<body>
<h2>Hello</h2>
<form action="<%=request.getContextPath() %>/login" method="post">
	username:<input type="text" name="username"/>
	password:<input type="password" name="password"/>
	<input type="submit">
</form>
</body>
</html>
