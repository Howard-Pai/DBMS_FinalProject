<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NCCU�ҵ{�d��-�d�ߵ��G</title>
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
        top: 30%;
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
	<h2>�j�M���G(TA��)</h2>
	<div align="right"><a href="index.jsp">�^�D��</a> / <a href="login.jsp">�n�J</a></div>
	<form action="search.jsp" name="form1" >
		<input type="submit" value="����" >
		
	</form >
	<form action="searchTA.jsp" name="form2">
		<input type="submit" value="TA��">
	</form>
	<table border="0" cellspacing="0" cellpadding="0" width="50%" >
		<tbody>
			<tr>
				<th  valign="top" ><h3>�ҵ{�W��</h3></th>
				<th  height="50px" valign="top" ><h3>�½ҦѮv</h3></th>
				<th width="10%" height="50px" valign="top" ><h3>�Ǧ~��</h3></th>
				<th width="10%" height="50px" valign="top" ><h3>�`�����</h3></th>
				<th width="10%" height="50px" valign="top" > </td>
			</th>

			<tr>
				<td width="10%" height="50px" valign="top" >��Ʈw�޲z </td>
				<td width="10%" height="50px" valign="top" > �P�P��</td>
				<td width="10%" height="50px" valign="top" > 109</td>
				<td width="10%" height="50px" valign="top" > 10</td>
				<td width="10%"  height="50px" valign="top" ><a href="dbms_comment.html">�ڭn����</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" > ��Ʈw�޲z</td>
				<td width="10%" height="50px" valign="top" >�P�P�� </td>
				<td width="10%" height="50px" valign="top" > 110</td>
				<td width="10%" height="50px" valign="top" > 10</td>
				<td width="10%" height="50px" valign="top" ><a href="dbms_comment.html">�ڭn����</a></td>
			</tr>

			<tr>
				<td width="10%" height="50px" valign="top" >��Ʈw�޲z </td>
				<td width="10%" height="50px" valign="top" >�P�P�� </td>
				<td width="10%" height="50px" valign="top" > 111</td>
				<td width="10%" height="50px" valign="top" > 10</td>
				<td width="10%" height="50px" valign="top" ><a href="dbms_comment.html">�ڭn����</a></td>
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