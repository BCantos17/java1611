<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	// Java
	String variable;
	public void go(){
		System.out.println("GO!");
	}
	ArrayList<String> values = new ArrayList<String>();		
 %>
Today's Date: <%= new Date() %>
<% // scriptlet
	variable = "Hello!";
	this.go();
	// implicit objects 
	out.println("<br/>" + variable); // out = shortcut for response.getWriter()
	values.add("Dan"); values.add("Tom"); values.add("Jill");
	values.add("Howie"); values.add("Randy"); values.add("Steve");
%>

<!-- Make a table using some dynamic values -->
<table>
	<tr> <th>Person Name</th> </tr>
	<%  
		for(String person : values){
			out.println("<tr><td>"+person+"</td></tr>");
		} 
	%>
</table>

</body>
</html>



