<%@page session="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL" value='..' scope="application"/>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="${baseURL}/resources/styles/style.css" rel="stylesheet" type="text/css"  media="all">
<script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script src="${baseURL}/resources/scripts/jquery.carouFredSel-6.0.4-packed.js" type="text/javascript"></script>
		
		
		
		<script type="text/javascript">
			$(function() {
				$('#carousel').carouFredSel({
					prev: '#prev',
					next: '#next',
					auto: {
						button: '#play',
						progress: '#timer',
						pauseOnEvent: 'resume'
					},
					scroll: {
						fx: 'fade'
					}
				});
				
				
			});
		</script>
<!--[if lte IE 7]>
<link rel="stylesheet" href="${baseURL}/styles/css/ie7.css">  
<![endif]-->  
	<!--[if IE 8]>  	
		<link rel="stylesheet" href="${baseURL}/styles/css/ie8.css"> 
<![endif]--> 
	
		
		</head>