<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="todolist.*,java.util.*,java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("run index page");
List<String> list = Connect.connect();
%>
<div>
<table border="1">
<tr><th>To-Do-List</th></tr>
<%for(int i=0;i<list.size();i++){%>
<tr>
<td><%out.println(i+1);%></td>
<td><%out.println(list.get(i));%></td>
<td><a href="#">Edit</a></td>
<td><a href="<jsp:forward page="Delete.java" />">Delete</a></td>
</tr>
<%}%>
</table>
</div>

<div>
<form method="POST" action="add">
<input type="text" name="name">
<button type="submit">ADD</button>
</form>
</div>
</body>
</html>