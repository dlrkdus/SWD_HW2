<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
	<div><a href="hello.do">http://.../helloSpringIdol-JavaConfig/hello.do</a></div><br>
	<div><a href="hello.do?name=Chris">http://.../helloSpringIdol-JavaConfig/hello.do?name=Chris</a></div>
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
