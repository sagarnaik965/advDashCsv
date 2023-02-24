<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Aadhaar Data vault</title>

</head>


<%@ include file="header.jsp"%>

<body onload="GenerateCaptcha()">

	<%-- <h3 style="text-align: center; color: red">${OnFail}</h3> --%>


	<h3 class="alert"
		style="text-align: center; color: green; height: 10px">${OnSucces}</h3>
	<h3 class="alert" style="text-align: center; color: red; height: 10px">${OnFail}</h3>
	<div class="container" style="margin-left: 0px; margin-top: 20px">
		<form id="Form" method="POST" action="/Query">
			<div class="col-md-3"></div>
			<div class="col-md-3">

				<div class="form-group">
					<label for="exampleInputNameOfContactPerson">Name</label> <input
						type="text" class="form-control"
						id="exampleInputNameOfContactPerson" placeholder="Name"
						name="NameOfContactPerson"  onchange="Namevalidate()" required>
				</div>

				<div class="form-group">
					<label for="exampleInputDepartmnetName">Department
						Name </label> <input type="text" class="form-control"
						id="exampleInputDepartmnetName" placeholder="Departmnet Name"
						name="DepartmnetName" onchange="DeptNamevalidate()" required>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email Address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						placeholder="Email" name="EmailAddress" required>
				</div>
				<div class="form-group">
					<label for="exampleInputMobile">Mobile No </label> <input
						type="tel" class="form-control" id="exampleInputMobile"
						placeholder="Contact Number" name="MobieNo" maxlength="10" 
					 onchange="mobilevalidate()"
						required>
				</div>
			</div>

			<div class="col-md-3">

				<label for="exampleFormControlTextarea1" class="form-label">Query</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					name="Description" placeholder="maximum 300 character is allowed"
					rows="3" maxlength="300" required></textarea>

				<br /> Enter the Captcha: <input type="text" id="txtCompare" />

				<!--  <div id="txtCaptcha" style="text-align: center; border: none; font-weight: bold; font-size: 20px; font-family: Modern"></div> -->
				<input disabled type="button" id="txtCaptcha"
					style="text-align: center; pointer-events: none; width: 150px; float: left; border: none; font-weight: bold; font-size: 20px; font-family: Modern" />
					<img style=" float: center; margin-top: 8px"  src="resources/images/refresh.png" alt="GOI Logo" onclick="GenerateCaptcha();">
				<!-- <input style="width: 70px; float: right; margin-top: 2px" type="button"
					id="btnrefresh" value="Refresh" onclick="GenerateCaptcha();" /> -->
				<!-- <input  id="btnValid" type="button"
					value="Check" onclick="alert(ValidCaptcha());" /> -->
				<br />
				<br />
				<button style="float: right" type="submit" class="btn btn-default"
					onclick="ValidCaptcha();">Submit</button>
			</div>
			<div class="col-md-3"></div>

		</form>
	</div>


	<script type="text/javascript">  
        /* Function to Generat Captcha */  
        function GenerateCaptcha() {  
            var chr1 = Math.ceil(Math.random() * 10) + '';  
            var chr2 = Math.ceil(Math.random() * 10) + '';  
            var chr3 = Math.ceil(Math.random() * 10) + '';  
  
            var str = new Array(4).join().replace(/(.|$)/g, function () { return ((Math.random() * 36) | 0).toString(36)[Math.random() < .5 ? "toString" : "toUpperCase"](); });  
            var captchaCode = str + chr1 + ' ' + chr2 + ' ' + chr3;  
            document.getElementById("txtCaptcha").value = captchaCode  
        }  
  
        /* Validating Captcha Function */  
        function ValidCaptcha() {  
            var str1 = removeSpaces(document.getElementById('txtCaptcha').value);  
            var str2 = removeSpaces(document.getElementById('txtCompare').value);  
  
            if (str1 == str2)
            	{            	 
            	
            	}
            else{
            	document.getElementById("Form").reset();
            	GenerateCaptcha()
            	alert("Captcha entered is incorrect..!")                 	
            }    
            
        }  
  
        /* Remove spaces from Captcha Code */  
        function removeSpaces(string) {  
            return string.split(' ').join('');  
        }  
        
        function mobilevalidate()
        {
        	var x = document.getElementById("exampleInputMobile").value;
        	
        	if(isNaN(x))
        		{
        			alert("please enter proper mobile number")
        			document.getElementById('exampleInputMobile').value = ''
        			
        		}
        	
        	if(x.length !=10)
    		{
    			alert("please enter proper mobile number")
    			document.getElementById('exampleInputMobile').value = ''
    			
    		}        		
        }
        
         function Namevalidate()
        {
        	 var x = document.getElementById('exampleInputNameOfContactPerson').value;        	
        	if(containsNumbers(x))
        		{
        			alert("please enter proper name")
        			document.getElementById('exampleInputNameOfContactPerson').value = ''        			
        		} 	        	    		
        }
         
         function DeptNamevalidate()
         {
         	 var x = document.getElementById('exampleInputDepartmnetName').value;        	
         	if(containsNumbers(x))
         		{
         			alert("please enter proper department name")
         			document.getElementById('exampleInputDepartmnetName').value = ''        			
         		} 	        	    		
         }
         
         
         function containsNumbers(str) {
        	  return /\d/.test(str);
        	}
        
       
    </script>



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
			}, 1000);
			 

		});
	</script>

</body>
<%@ include file="footer1.jsp"%>





</html>