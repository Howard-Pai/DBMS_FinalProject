<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢-課程評論</title>
	<style type="text/css">
		body 
		{
			font-family: verdana;
	     	background-color: rgb(250, 248, 245);
    	}
    	h2
		{
			font-family: verdana;
			font-size: 300%;
			position: absolute;
			top: 5%;
			left: 50%;
			transform: translate(-50%,-50%);
		}
    	table
	    {
	    	font-family: verdana;
		    padding:5px 15px; border:2px black solid;
			cursor:pointer;
			-webkit-border-radius: 5px;
			border-radius: 5px; 
			color: rgb(0, 0, 0);
	        //display: block;
	        margin: auto;
	        position: absolute;
	        top: 30%;
	        left: 50%;
	        transform: translate(-50%,-50%);
	        width: 45%;
	    }
    	table td,
	    table th
	    {
	    	font-family: verdana;
	    	text-align: center;
	    	//padding: 1px;
	    	width="10%" height="50px"
	    }
	</style>
</head>
<body>
	<div align="right"><a href="index.jsp">回主頁</a> / <a href="login.jsp">登入</a></div>
	<form>
		<h2>${courseName}/${professor}</h2>

		<table>
			<tbody>
				<tr>
					<th><h3>甜度</h3></th>
					<td>${sweetness}</td>
				</tr>

				<tr>
					<th><h3>負荷度</h3></th>
					<td>${loading}</td>
				</tr>

				<tr>
					<th><h3>困難度</h3></th>
					<td>${difficulty}</td>
				</tr>
				
				<tr>
					<th><h3>其他評論</h3></th>
					<td>${comment}</td>
				</tr>
				
			</tbody>
		</table>
	</form>
</body>
</html>