<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢-登入</title>
	<style >
	h1
	{
		font-family: verdana;
		font-size: 300%;
		position: relative;
		top: 20%;
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
	a
	{
		position: absolute;
		right: 1%;
	}
	
	</style>
</head>
<body>
	<a href="dbms_webpage.html">回主頁</a>
	<form action="dbms_webpage.html">
		<h1>登入</h1>
		<h2>帳號</h2> <input type="text" name="account" placeholder="學校信箱">
		<h2>密碼</h2> <input type="passwaord" name="password" placeholder="身分證前四碼"><br><br><br>
		<input type="submit" value="登入">&nbsp;<input type="submit" value="註冊" style="margin-left:10px;">
	</form>
</body>
</html>