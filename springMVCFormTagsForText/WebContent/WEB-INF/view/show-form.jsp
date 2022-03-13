<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<header>This is my Tag lib project</header>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		first name : <form:input path="firstName"/>
		<br><br>
		last name : <form:input path="lastName"/>
		<br><br>
		Sex : 
		Male  <form:radiobutton path="sex" value="Male"/>
		Female <form:radiobutton path="sex" value="Female"/>
		<br><br>
		
		OS : 
		Windows <form:checkbox path="operatngSystem" value="Windows"/>
		Ubuntu <form:checkbox path="operatngSystem" value="Ubuntu"/>
		Max <form:checkbox path="operatngSystem" value="Mac"/>
		<br><br>
		<form:select path="country">
		<%-- <form:option value="India" label="India"/>
		<form:option value="Nepal" label="Nepal"/>
		<form:option value="Shrilankd" label="Shrilanka"/> --%>
		<form:options items="${theCountryOptions}"/>
		</form:select>
		
		<br><br>
		
		<input type="submit" value="submit">
			
	</form:form>

</body>

</html>
