<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢-註冊</title>
</head>
<body>
<style >
	h1
	{
		font-family: verdana;
		font-size: 300%;
		position: relative;
		top: 25%;
		left: 50%;
		transform: translate(-50%,-50%);
	}
	body {

      background-color: rgb(250, 248, 245);
    }
    form {
    	color: rgb(0, 0, 0);
        display: block;
        margin: auto;
        position: absolute;
        top: 40%;
        left: 50%;
        transform: translate(-50%,-50%);

    }
    input[type="submit"]
    {
    	font-family: verdana;
    padding:5px 15px; background:#ccc; border:0 none;
	cursor:pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px; 
	height: 33px;
    }
    input[type="text"]
    {
    	font-family: verdana;
    padding:5px 15px; border:2px black solid;
	cursor:pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px; 
	height: 20px;
	}
	input[type="passwaord"]
    {
    	font-family: verdana;
    padding:5px 15px; border:2px black solid;
	cursor:pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px; 
	height: 20px;
	}
	input[type="email"]
    {
    	font-family: verdana;
    padding:5px 15px; border:2px black solid;
	cursor:pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px; 
	height: 20px;
	}
	a
	{
		position: absolute;
		right: 1%;
	}
	
	</style>
</head>
<body>
	
	<a href="index.jsp">回主頁</a>
	<form action="Register">
		<h1>註冊</h1>
		<h2>學號</h2> <input type="text" name="studentID" placeholder="">
		<h2>姓名</h2> <input type="text" name="studentName" placeholder="">
		<h2>科系</h2> <input type="text" name="major" placeholder="">
		<h2>信箱</h2> <input type="email" name="mail" placeholder="">
		<h2>密碼</h2> <input type="passwaord" name="password" placeholder=""><br><br><br>
		<input type="submit" value="註冊">
	</form>

</body>
</html>