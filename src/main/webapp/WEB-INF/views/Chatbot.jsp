<%@ page import = "java.io.*,java.util.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<link rel="stylesheet" href="resources/css/w3css.css" />	

<link rel="stylesheet" href="resources/css/chatbotstyle.css" />
<link rel="stylesheet" href="resources/css/holder.css" />


 <style>
</style>
</head>
<body>

 
	<script>
		$(document).on('click', '#clickMe', function() {
			document.getElementById("close_iframe").style.display = "block";
			document.getElementById("gparent").style.visibility = "visible";
			document.getElementById("parent").style.visibility = "visible";
			document.getElementById("clickMe").style.visibility = "hidden";

		})
		$(document).on('click', '#close_iframe', function() {
			document.getElementById("close_iframe").style.display = "none";
			document.getElementById("parent").style.visibility = "hidden";
			document.getElementById("gparent").style.visibility = "hidden";
			document.getElementById("clickMe").style.visibility = "visible";

		})
		</script>
		
		

	

	<div id=logo>
		<div class="user-photo">
			<img id="clickMe" src="resources/images/adv_avatar_new.png" width="10px"
				class="w3-display-bottomright">
		</div>
	</div>
	<div id=gparent style="visibility: hidden;">
		<div id="parent">
			<iframe src="https://botai.in/Advbot/"></iframe>
			<button class="btn" id="close_iframe"
				style="display: block; color: white; background: #4094e7; border: none; font-size: 26px">
				<i class="fa-solid fa-circle-chevron-down"></i>
			</button>

		</div>
	</div>




</body>
</html>





