<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Login</title> 
</head> 
<body> 
<h3>Login Page</h3> 
<body> 


 <form:form method="POST" action="existsUser" modelAttribute="userform"> 
		<table> 
<tr> 
<td><form:label path="username">Name</form:label></td> 
<td><form:input path="username" /></td> 
</tr> 
<tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>

</table> 
</form:form> 
</body> 
</html> 

