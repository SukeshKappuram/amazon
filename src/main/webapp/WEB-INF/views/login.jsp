<html>
	<head>
		<title>Amazon</title>
	</head>
	<body>
	<%@include file="header.jsp" %>
	<h1></h1>
		<div class='container-fluid' style="width:50%">
		<form:form action="Login" method='POST'>
			<fieldset>
				<legend>User Login</legend>
				<div class='form-group'>
					<form:input type='email' class="form-control" path="emailId" placeholder='Email Id'/>
				</div>
				<div class='form-group'>
					<form:input type='password' class="form-control" path="password" placeholder='Password'/>
				</div>
				<div class='form-group'>
					<input type='reset' class="btn btn-default" value='Reset'/>
					<input type='submit' class="btn btn-primary" value='Login'/>
				</div>
			</fieldset>
		</form:form>
		</div>
	<%@include file="footer.jsp" %>
	</body>
</html>