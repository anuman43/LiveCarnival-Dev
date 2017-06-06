<%@page session="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL" value='..' scope="application"/>
<head>
		<title>Vertie-Alpha</title>
		<link rel="stylesheet" type="text/css" href="${baseURL}/resources/styles/style1.css">
		<!-- START Responsive Link-->
        <link rel="stylesheet" type="text/css" href="${baseURL}/resources/styles/responsive.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- END Responsive Link-->
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		  <script>
		   $(function() {
			$nav = $('.nav-list');
			
			$('.menu-icon').click(function() {
			 $nav.slideToggle();
			});
			
			$(window).resize(function() {
			 if ( $(window).width() >= 640 ) {
			  $nav.show();
			 } else {
			  $nav.hide();
			 }
			});
			
		   });

		   $(document).load(function(){
				$.ajax({
					
					url:"recentSearches",
					dataType:"text",
					success: function(response)
					{
						console.log(response);
						searchMatches = response.split("|");
						console.log(searchMatches);
					},
					error: function(xhr,status,errorThrown)
					{
						alert("There was a problem with the AJAX call");
						console.log("The status is ", status);
					},
					type: "GET" });
			});
	        
		  </script>
	</head>