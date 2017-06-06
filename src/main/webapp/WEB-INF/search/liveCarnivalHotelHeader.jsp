<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    
    <!--  <link rel="stylesheet" href="${baseURL}/resources/styles/main.css"/>-->
    <!-- styles/styles.css 
    <link rel="stylesheet" href="${baseURL}/resources/styles/style1.css"/>
    -->
   
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
</head>
<body>
 <div class="container">