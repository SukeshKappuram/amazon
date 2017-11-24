<html>
	<head>
		<title>Amazon</title>
	</head>
	<body>
		<%@include file="header.jsp" %>
		<div class='container-fluid' style="width:50%">
		<form:form action="Category" method='POST'>
			<fieldset>
				<legend>Category</legend>
				<div class='form-group'>
					<form:input type='text' class="form-control" path="name" placeholder='Category Name'/>
				</div>
				<div class='form-group'>
					<form:textarea class="form-control" path="description" placeholder='Category Description'></form:textarea>
				</div>
				<div class='form-group'>
					<input type='reset' class="btn btn-default" value='Reset'/>
					<input type='submit' class="btn btn-primary" value='Add Category'/>
				</div>
			</fieldset>
		</form:form>
		</div>
		<%@include file="footer.jsp" %>
	</body>
</html>