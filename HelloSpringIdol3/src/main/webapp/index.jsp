<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Welcome</title>
</head>
<body>

	<form method="post" action="performUsingComm">
    Performer:
    <select name="id">
    <option value="kenny">kenny</option>
    <option value="hank">hank</option>
    <option value="duke">duke</option>
    <option value="lena">lena</option>
    </select> <br>
    Your name: <input type="text" name="requester" /><br/>
    <input type="submit" value="전송"/>
    </form>
</body>
</html>
