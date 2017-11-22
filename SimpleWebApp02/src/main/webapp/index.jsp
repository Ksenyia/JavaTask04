<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<body>
<hr/>
<form action="Controller" method = "post">
	<input type = "hidden" name = "command" value = "parsering" />
	<input type="submit" name = "parser" value="SAX"/><br/>
	<input type="submit" name = "parser" value="STAX"/><br/>
	<input type="submit" name = "parser" value="DOM"/><br/>
</form>
</body>
</html>