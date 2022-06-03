<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU�ҵ{�d��-�n�J</title>
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
	<a href="dbms_webpage.html">�^�D��</a>
	<form  method = post> <!--�쥻��dbms_webpage.html-->
		<h1>�n�J</h1>
		<h2>�b��</h2> <input type="text" name="account" placeholder="�ǮիH�c">
		<h2>�K�X</h2> <input type="passwaord" name="password" placeholder="�����ҫe�|�X"><br><br><br>
		<input type="submit" name="action" value="�n�J" onclick ="form.action='Login'">&nbsp;
		<input type="submit" name="action" value="���U" onclick ="form.action='Regiseter'" style="margin-left:10px;">
	</form>
</body>
</html>