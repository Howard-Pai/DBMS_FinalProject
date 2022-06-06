<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢-我要評論</title>
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
		h3[name='comment_lecture']
		{
			font-family: verdana;
			position: absolute;
			top: 18%;
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
	        top: 70%;
	        left: 50%;
	        transform: translate(-50%,-50%);
	        width: 45%;
	    }
    	table td,
	    table th
	    {
	    	font-family: verdana;
	    	text-align: left;
	    	padding: 1px;
	    	width="15%" height="50px"
	    }
	    input[name='sub']
	    {
		    padding:5px 15px; background:#ccc; border:0 none;
			cursor:pointer;
			-webkit-border-radius: 5px;
			border-radius: 5px; 
			height: 33px;
			position: absolute;
			top: 110%;
			left: 45%;
	    }
	</style>
</head>
<body>
	<div align="right"><a href="loginWeb.jsp">回主頁</a></div>
	<form>
		<h2>我要評論</h2>
		<h3 name='comment_lecture'>${courseName}${semester}學年度</h3>
		<input type="hidden" name="courseID" value="${courseID}" />
		<input type="hidden" name="studentID" value="${studentID}" />
		<table>
			<tbody>
				<tr>
					<th><h3>總評分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3></th>
					<td>
						<select name="overall">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>

				<tr>
					<th><h3>甜度</h3></th>
					<td>
						<select name="sweetness">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>

				<tr>
					<th><h3>涼度</h3></th>
					<td>
						<select name="loading">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>

				<tr>
					<th><h3>課程困難度</h3></th>
					<td>
						<select name="difficulty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>

				<tr>
					<th><h3>志願排序</h3></th>
					<td>
						<input type="number" name="rank" min="1" max="99" required>
					</td>
				</tr>

				<tr>
					<th><h3>補充評論</h3></th>
					<td>
						<textarea name="text_comment" 
								  rows="5" 
								  cols="30" 
								  placeholder="輸入對課程的補充評論"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" name="sub" value="送出" onclick="form.action='AddComment'">
	</form>
	

</body>
</html>