<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
	<h2>搜尋結果(TA課)</h2>
	<div align="right"><a href="index.jsp">回主頁</a> / <a href="login.jsp">登入</a></div>
	<!--
	<form action="search.jsp" name="form1" >
		<input type="submit" value="正課" >
		
	</form >
	<form action="searchTA.jsp" name="form2">
		<input type="submit" value="TA課">
	</form>
	-->
	<table border="0" cellspacing="0" cellpadding="0" width="50%" >
		<tbody>
			<tr>
				<th  valign="top" ><h3>課程名稱</h3></th>
				<th  height="50px" valign="top" ><h3>助教</h3></th>
				<th width="10%" height="50px" valign="top" ><h3>總體評分</h3></th>
				<th width="10%" height="50px" valign="top" > </th>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="taCourseComment?taCourseID=${taCourseID0}">${taCourseName0}</a></td>
				<td width="10%" height="50px" valign="top" > ${taName0} </td>
				<td width="10%" height="50px" valign="top" > ${score0} </td>
				<td width="10%"  height="50px" valign="top" ><a href="LinkToAddComment?taCourseID=${taCourseID0}">${addComment0}</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="taCourseComment?taCourseID=${taCourseID1}">${taCourseName1}</a></td>
				<td width="10%" height="50px" valign="top" > ${taName1} </td>
				<td width="10%" height="50px" valign="top" > ${score1} </td>
				<td width="10%"  height="50px" valign="top" ><a href="LinkToAddComment?taCourseID=${taCourseID1}">${addComment1}</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" ><a href="taCourseComment?taCourseID=${taCourseID2}">${taCourseName2}</a></td>
				<td width="10%" height="50px" valign="top" > ${taName2} </td>
				<td width="10%" height="50px" valign="top" > ${score2} </td>
				<td width="10%"  height="50px" valign="top" ><a href="LinkToAddComment?taCourseID=${taCourseID2}">${addComment2}</a></td>
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