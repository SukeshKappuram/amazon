<html>
<head>
	<title>Amazon</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<h1></h1>
	<div class='container-fluid' style="width:50%">
	<form:form action="SignUp" method='POST'>
		<fieldset>
		<legend>User Registration</legend>
			<div class="form-group">
				<form:input type='text' class='form-control' path="firstName" placeholder='First Name'/>
			</div>
			<div class="form-group">
				<form:input type='text' class='form-control' path="lastName" placeholder='Last Name'/>
			</div>
			<div class="form-group">
				<form:input type='email' class='form-control' path="emailId" placeholder='Email Id'/>
			</div>
			<div class="form-group">
				<form:input type='password' class='form-control' path="password" placeholder='Password'/>
			</div>
			<div class="form-group">
				<input type="text" name="dob" class='form-control' placeholder="Date of Birth(MM/dd/yyyy)" path="dob" value="<fmt:formatDate value="${command.dob}" pattern="MM/dd/yyyy" />"/>
			</div>
			<div class="form-group">
				<input type='reset' class="btn btn-default" value='Reset'/>
				<input type='submit'  class='btn btn-primary' value='Register'/>
			</div>
		</fieldset>
	</form:form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>