<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header included here -->
<%-- <%@ include file="header.jsp"%> --%>
<!--    Table starts here -->

<div class="col-md-11" style="margin-top: 140px">	
  <div class="loading" id="loading">Loading</div>	
  <div class="loading1" id="check" style="display: none" >Loading1</div>	
  
	<div class="closebutton">
		<button id="closed_table" onclick="closeStyle()"
			style="display: none; font-size: 0px; position: relative; bottom: 215px; left: 780px; background-color: grey; border-style: none; border-radius: 50%;">
			<img src="resources/images/cross.jpg"
				style="height: 50px; width: 50px;">
		</button>
		<iframe id="gfgFrame" src=""
			style="height: 500px; width: 100%; display: none; position: relative; bottom: 120px; left: 60px; right: 60px;"></iframe>

		<img src="resources/images/Data_Analytic.png" id="imgid"
			class="data_analytics" position: relative; border: 2px solid
			#3e6e2c;cursor: pointer; padding-right: 0px;" onclick="navigate()">
	</div>
	</div>
	
	<br/>
	
	

	<style>
.data_analytics {
	position: relative;
	bottom: 120px;
	left: 680px;
}
</style>

	

<%-- <%@ include file="footer1.jsp"%> --%>


<script type="text/javascript">
setTimeout(() => {
	  document.location.reload();
	}, 60000);
</script>

			<script>		
			 function navigate() {
				 //alert("inside navigate");
					document.getElementById("gfgFrame").src="https://10.210.12.192:5601/app/dashboards#/view/c6e108e0-a3b8-11ed-a23b-dbfa80c75be6?embed=true&_g=(filters%3A!()%2CrefreshInterval%3A(pause%3A!t%2Cvalue%3A0)%2Ctime%3A(from%3Anow%2Fd%2Cto%3Anow%2Fd))&show-time-filter=true&hide-filter-bar=true";
			        var element1=document.getElementById("closed_table");
					/* element1.style.display="block"; */
					var element2=document.getElementById("imgid");
					element2.style.display="none";
					var element = document.getElementById("gfgFrame");
                   element.style.display = "block";                 
				}
			
			 navigate();
			 getIframeContent();
			 
			</script>

<!-- <script>
  function checkIframeLoaded() {
    // Get a handle to the iframe element
    var iframe = document.getElementById('gfgFrame');
    var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;
   
    // Check if loading is complete
    if (  iframeDoc.readyState  == 'complete' ) {
    	
        //iframe.contentWindow.alert("Hello");
        iframe.contentWindow.onload = function(){
            alert("I am loaded");
        };
        // The loading is complete, call the function we want executed once the iframe is loaded
        afterLoading();
        return;
    } 
    alert("I am not here");
    // If we are here, it is not loaded. Set things up so we check   the status again in 100 milliseconds
    window.setTimeout(checkIframeLoaded, 100);    
}
  checkIframeLoaded()

function afterLoading(){
    alert("I am here");
}
</script> -->


<!-- <script>
const iframeEle = document.getElementById('gfgFrame');
const loadingEle = document.getElementById('loading');
const checkel = document.getElementById('check');

iframeEle.addEventListener('load', function () {
    // Hide the loading indicator
    alert("inside event")
    loadingEle.style.display = 'none';
    checkel.style.display = '';

    // Bring the iframe back
    iframeEle.style.opacity = 1;
    
});
</script> -->



