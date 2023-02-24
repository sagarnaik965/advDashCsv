<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Aadhaar Data vault</title>

</head>


<%@ include file="header.jsp"%>

<body>

	<%-- <h3 style="text-align: center; color: red">${OnFail}</h3> --%>


	<h3 class="alert"
		style="text-align: center; color: green; height: 10px">${OnSucces}</h3>
	<h3 class="alert" style="text-align: center; color: red; height: 10px">${OnFail}</h3>
	
	
	
	
 	


<script type="text/javascript">
		$(document).ready(function() {
			GenerateCaptcha()
		});
	</script>



	<script type="text/javascript">
		$(document).ready(function() {

			window.setTimeout(function() {
				$(".alert").fadeTo(500, 0).slideUp(500, function() {
					$(this).remove();
				});
				window.location = '/Sendemail';
			}, 2000);
			
			
			 

		});
	</script>

</body>
<%@ include file="footer1.jsp"%>





