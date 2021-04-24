<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>  Model Attribute </title>
</head>
<body>
<form:form action="validateFormVersion4" modelAttribute="studentName"> 
<form:input path="firstName"/>
<input type="submit"  value=" Submit the form">
</form:form>
</body>
</html>