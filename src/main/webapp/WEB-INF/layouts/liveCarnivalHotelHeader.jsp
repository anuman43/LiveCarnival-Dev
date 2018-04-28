<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL" value='..' scope="application"/>
<c:set var="travelSearchURL" value="travelSearch" scope="application"/>
<c:set var="hotelSearchURL" value="hotelSearch" scope="application"/>
<c:set var="eventsSearchURL" value="events" scope="application"/>
<c:set var="sponsorshipURL" value="sponsorship" scope="application"/>

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
	<link rel="stylesheet" type="text/css" href="${baseURL}/resources/styles/main.css"/>
    
    <!--  <link rel="stylesheet" href="${baseURL}/resources/styles/main.css"/>-->
    <!-- styles/styles.css 
    <link rel="stylesheet" href="${baseURL}/resources/styles/style1.css"/>
    -->
   
  
<script type="application/javascript" src="${baseURL}/resources/scripts/jquery-1.12.4.js"></script>
<!-- scripts/vendors.js -->

<script type="application/javascript" src="${baseURL}/resources/vendors/bootstrap/js/bootstrap.js"></script>
<!-- Twitter Typeahead -->
<script type="application/javascript" src="${baseURL}/resources/vendors/typeahead/typeahead.bundle.min.js"></script>

<script type="application/javascript" src="${baseURL}/resources/vendors/bootstrap/js/bootstrap3-typeahead.js"></script>



<script type="text/javascript">

$(document).ready(function()
		{

	var liveCarnivals = new Bloodhound({
		  datumTokenizer: Bloodhound.tokenizers.whitespace,
		  queryTokenizer: Bloodhound.tokenizers.whitespace,
		  local:  ["ANU(VC Bird Intl)","ATL(Hartsfield Jackson Atlanta Intl)","AUA(Reina Beatrix Intl)","MYNN(Lynden Pindling Intl)","BWI(Baltimore Washington Intl) ","BZE(Philip S W Goldson Intl)","BGI(Grantley Adams Intl)","BDA(Bermuda Intl)","BOS(Logan International)","JFK(John F Kennedy Intl)","GCM(Owen Roberts Intl)","CLT(Charlotte Douglas Intl)","HAV(Jose Marti Intl)","CUR(Hato)","DCA(Ronald Reagan Washington Natl)","DOM(Melville Hall)","EWR(Newark Liberty Intl)","STI(Cibao Intl)","GND(Point Salines Intl)","GBJ(Les Bases Airport)","SFC(St-François Airport)","PAP(Toussaint Louverture Intl)",
					  "CAP(Cap Haitien Intl)","IAH(George Bush Intercontinental)","MBJ(Sangster Intl)","LHR(Heathrow)","LGW(Gatwick)","LAX(Los Angeles Intl)","FDF(Martnique Aime Cesair Intl)","MIA(Miami Intl)","MCO(Orlando Intl)","MSY(Louis Armstrong New Orleans Intl)","PHL(Philadelphia Intl)","SJU(San Juan Intl)","BQN(Rafael Hernandez)","GIG(Rio de Janiero Intl)","SBH(Gustaf III)","STX(Henry E Rohlsen)","SKB(Robert L Bradshaw)","SXM(Princess Juliana Intl)","STT(Cyril E King)","SVD(Argyle Intl)","TPA(Tampa Intl)","YYZ(Pearson Intl)","SLU(George F Charles)","UVF(Hewanorra Intl)","GDT(JAGS McCartney International Airport","city)",
					  "BZE(Philip S W Goldson Intl)","GEO(Cheddi Jagan Intl)","SYQ(Tobias Bolanos International Airport)","SAL(El Salvador Intl)","GUA(La Aurora Intl)","SAP(La Mesa Intl)","LCE(Goloson Intl)","RTB(Juan Manuel Galvez Intl)","TGU(Toncontin Intl)","ACA(General Juan N Alvarez Intl)","NTR(Del Norte Intl)","AGU(Jesus Teran Intl)","HUX(Bahias De Huatulco Intl)","CME(Ciudad Del Carmen Intl)","CUL(Culiacan Intl)","MGA(Mangua Intl)","PTY(Tocumen Intl)","POS(Piarco Intl)","TAB(Crown Point Intl)","IAD(Washington Dulles Intl)",]
		});

		// initialize the bloodhound suggestion engine
		liveCarnivals.initialize();

		$("#departTxtInput").typeahead({
		  items: 4,
		  source:liveCarnivals.ttAdapter()
		});

		$("#destinationTxt").typeahead({
			  items: 4,
			  source:liveCarnivals.ttAdapter()
			});

	});

    </script>

<!-- scripts/scripts.js -->
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
<script type="application/javascript" src="${baseURL}/resources/vendors/angularjs/angular.min.js"></script>
<script type="application/javascript" src="${baseURL}/resources/vendors/revslider-jquery/slider/jquery.themepunch.revolution.min.js"></script>

<script type="application/javascript" src="${baseURL}/resources/scripts/app.js"></script>


</head>
<body>
 <div class="container">
 