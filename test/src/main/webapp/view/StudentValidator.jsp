<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>  Model Attribute </title>
</head>
<body>
<form:form action="checkForm" modelAttribute="studentName"> 
First Name : <form:input path="firstName"/>
<br>
<br>
Last Name : <form:input path="lastName"/>
<form:errors path="lastName"/>
<br>
<br>
Age : <form:input type="number" path="age" />
<form:errors path="age"/>
<br>
<br>

Date of Birth : 
<form:errors path="dob"/>
<br>
<br>

<input type="submit"  value=" Submit the form">
</form:form>
</body>
</html>