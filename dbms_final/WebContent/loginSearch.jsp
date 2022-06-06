<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU課程查詢-查詢結果</title>
	<style type="text/css">
	h2
	{
		font-family: verdana;
		font-size: 300%;
		position: absolute;
		top: 5%;
		left: 50%;
		transform: translate(-50%,-50%);
	}
	body 
	{
		font-family: verdana;
    	background-color: rgb(250, 248, 245);
    }
    form[name="form1"]
    {
    	color: rgb(0, 0, 0);
        display: block;
        margin: auto;
        position: absolute;
        top: 16%;
        left: 27%;
        transform: translate(-50%,-50%);
       	display: inline;
    }
    form[name="form2"]
    {
    	color: rgb(0, 0, 0);
        display: block;
        margin: auto;
        position: absolute;
        top: 16%;
        left: 30.5%;
        transform: translate(-50%,-50%);
       	display: inline;
    }
    input
    {
	    padding:5px 15px; background:#ccc; border:0 none;
		cursor:pointer;
		-webkit-border-radius: 5px;
		border-radius: 5px; 
		height: 33px;
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
        top: 40%;
        left: 50%;
        transform: translate(-50%,-50%);
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
	<h2>搜尋結果(正課)</h2>
	<div align="right">
		<a href="loginWeb.jsp">回主頁</a>
		<p>${studentID}</p>
	</div>
	<!-- 
	<form action="search.jsp" name="form1" >
		<input type="submit" value="正課" >
		
	</form >
	<form action="searchTA" name="form2">
		<input type="submit" value="TA課">
	</form>
	-->
	<table border="0" cellspacing="0" cellpadding="0" width="50%" >
		<tbody>
			<tr>
				<th  valign="top" ><h3>課程名稱</h3></th>
				<th  height="50px" valign="top" ><h3>授課老師</h3></th>
				<th width="10%" height="50px" valign="top" ><h3>學年度</h3></th>
				<th width="10%" height="50px" valign="top" ><h3>總體評分</h3></th>
				<th width="10%" height="50px" valign="top" > </td>
			</th>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="CourseComment?courseID=${courseID0}&studentID=${studentID}">${courseName0}</a></td>
				<td width="10%" height="50px" valign="top" > ${professorName0} </td>
				<td width="10%" height="50px" valign="top" > ${semester0} </td>
				<td width="10%" height="50px" valign="top" > ${score0} </td>
				<td width="10%"  height="50px" valign="top" ><a href="LinkToAddComment?courseID=${courseID0}&studentID=${studentID}">${addComment0}</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="CourseComment?courseID=${courseID1}&studentID=${studentID}">${courseName1}</a></td>
				<td width="10%" height="50px" valign="top" >${professorName1} </td>
				<td width="10%" height="50px" valign="top" > ${semester1} </td>
				<td width="10%" height="50px" valign="top" > ${score1} </td>
				<td width="10%" height="50px" valign="top" ><a href="LinkToAddComment?courseID=${courseID1}&studentID=${studentID}">${addComment1}</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="CourseComment?courseID=${courseID2}">${courseName2}</a></td>
				<td width="10%" height="50px" valign="top" > ${professorName2} </td>
				<td width="10%" height="50px" valign="top" > ${semester2} </td>
				<td width="10%" height="50px" valign="top" > ${score2} </td>
				<td width="10%" height="50px" valign="top" ><a href="LinkToAddComment?courseID=${courseID2}&studentID=${studentID}">${addComment2}</a></td>
			</tr>

		</tbody>
	</table>
</body>
</html>

<script type="text/javascript">
	function f1()
	{
		document.pay.action=
	}
</script>