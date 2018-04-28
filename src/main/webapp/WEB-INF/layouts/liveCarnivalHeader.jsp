<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="baseURL" value='..' scope="application"/>
<!doctype html>
<html data-ng-app="app" class="ng-cloak">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Live4Carnival</title>

    <!-- styles/vendors.css -->
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/revslider-jquery/slider.css" media="screen" />

    
    
   
   <script type="text/javascript">
    function getResultsPage(PageNumber)
	{
		//alert("Inside getResultsPage");
		if(PageNumber != null)
			{
				//alert("Inside getResultsPage");
				var resultSetId = "<c:out value='${searchModel["currentSearch"].searchId}'/>";
				var pageStr = "";
				pageStr =+ "page";
				document.getElementById("page" + PageNumber).href += "?page=" + PageNumber + "&resultsId=" + resultSetId; 
				return true;
			}
		else
			{
				alert("Cannot navigate without search number");
				return false;
			}
	}

	function scrollBack()
	{
		//resultPage.action +=
	}

	function scrollForward()
	{

	}

	function newSearch()
	{
		if(document.getElementById('inlineResultTxt').value != null )
			{
				//document.getElementById("resultSearchForm").action +="${baseURL}" + "<c:out value='${searchModel["keywordSearch"]}'/>" + "?searchWords=" + document.getElementById('inlineResultTxt').value;
				//document.inline_search_frm.action +="${baseURL}" + "<c:out value='${searchModel["keywordSearch"]}'/>" + "?searchWords=" + document.getElementById('inlineResultTxt').value;
				//window.alert(document.pageSearchForm.action);
				//document.pageSearchForm.action += "?searchWords=" + document.getElementById('inlineResultTxt').value;
				//window.alert(document.pageSearchForm.action);
				document.pageSearchForm.submit();
			}	
		
	}



	

</script>

<script type="application/javascript" src="${baseURL}/resources/scripts/jquery-1.12.4.js"></script>
<!-- scripts/vendors.js -->

<script type="application/javascript" src="${baseURL}/resources/vendors/bootstrap/js/bootstrap.js"></script>

<script type="application/javascript" src="${baseURL}/resources/vendors/angularjs/angular.min.js"></script>
<script type="application/javascript" src="${baseURL}/resources/vendors/revslider-jquery/slider/jquery.themepunch.revolution.min.js"></script>
<script type="application/javascript" src="${baseURL}/resources/vendors/revslider-jquery/revslider.js"></script>

<!-- scripts/scripts.js -->
<script type="application/javascript" src="${baseURL}/resources/scripts/app.js"></script>
<script >

	$(document).ready(function(){
		//var searchURL = "<c:out value='${baseURL}/Carnivate/cseResults'/>";
		//submit search when onchange occurs in navigation form textfield
		 
		$("#searchTxt").change(function(event)
			{
				$("#navbarSearchTxt").submit();
				console.log("text entered");
				
		});
		
	});

</script>



</head>
<body>
 <div class="container">
