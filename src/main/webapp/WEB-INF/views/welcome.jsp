<%@page isELIgnored="false" %>

<html>
	<head>
		<title>Amazon</title>
	</head>
	<body>
		<%@include file="header.jsp" %>
		<div class="container-fluid bg-1 text-center">
  			<h3 class="margin">Who Am I?</h3>
  			<img src="http://images.indianexpress.com/2017/10/kohli_pti-m1.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="350" height="350">
  			<h3>I'm ${user.firstName} ${user.lastName}!!</h3>
		</div>
		
		<!-- Second Container -->
		<div class="container-fluid bg-2 text-center">
  			<h3 class="margin">What Am I?</h3>
  			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
  			<a href="#" class="btn btn-default btn-lg">
    			<span class="glyphicon glyphicon-search"></span> Search
  			</a>
		</div>
		
		<!-- Third Container (Grid) -->
<div class="container-fluid bg-3 text-center">    
  <h3 class="margin">Where To Find Me?</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <img src="https://953dbb3e023d8d2081dc-a6ac47d7e9972b6bed5824eadfd0b772.ssl.cf3.rackcdn.com/wp-content/uploads/2017/06/a-59.jpg" class="img-responsive margin" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-4"> 
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <img src="http://www.thehansindia.com/assets/kohli_5087.jpg" class="img-responsive margin" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-4"> 
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <img src="http://awallpapersimages.com/wp-content/uploads/2016/07/Virat-Kohli-Image-1024x512.jpg" class="img-responsive margin" style="width:100%" alt="Image">
    </div>
  </div>
</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>