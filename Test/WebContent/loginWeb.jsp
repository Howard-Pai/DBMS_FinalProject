<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢</title>
<style>
	h1
	{
		font-family: verdana;
		font-size: 300%;
		position: absolute;
		top: 20%;
		left: 50%;
		transform: translate(-50%,-50%);
	}
    body {
    	background-color: rgb(250, 248, 245);
    }
    img {
        display: block;
        margin: auto;
        width: 40%;
        position: absolute;
        top: 15%;
        left: 30%;
    }
    form {
        display: block;
        margin: auto;
        position: absolute;
        top: 37%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    input[type="submit"]
    {
    	padding:5px 15px; background:#ccc; border:0 none;
		cursor:pointer;
		-webkit-border-radius: 5px;
		border-radius: 5px; 
		height: 33px;
    }
    input[type="text"]
    {
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
	<h1 align="center" >NCCU政大課程查詢</h1>
	<div align="right"> ${username}</div>
	<form methd="post" action="Search" >
		<input type='text' name='keyword' placeholder='輸入課程名稱或相關資訊' size="40" width="40" height="10" />   
		<form >
			<input type='submit'  value='搜尋'  />
		</form>
	</form>

	
	
</body>
</html>