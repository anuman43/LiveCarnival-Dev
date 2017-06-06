<%@page session="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL" value='..' scope="application"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${baseURL}/resources/scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${baseURL}/resources/scripts/typeahead.bundle.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	var searchMatches; 
	var testMatch = '${searchModel["trending"]}';
	var testSearch = testMatch.split("|");
	var strMatchFunction = function(strs){

		var subSearchStr, searchStrMatches ;
			return function findMatchingStr(trendSearcStr,searchInStr)
			{
				searchStrMatches = [];
				
				subSearchStr = new RegExp(trendSearcStr,'i');

				$.each(strs,function(i,str){

					if(subSearchStr.test(str))
						{
						searchStrMatches.push({value:str});

						}
					
					})
					searchInStr(searchStrMatches);
				};
			
		};

		/**
		var states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California',
		              'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii',
		              'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana',
		              'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
		              'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
		              'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
		              'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island',
		              'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
		              'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
		            ];

		
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
        **/

$(document).ready(function(){
	
			console.log(searchMatches);
			searchMatches = [];
			$('#testTypeAheadTxt.typeahead').typeahead({
				
				hint:true,
				highlight:true,
				minLength:2
				},
				{
					name:'testSearch',
					displayKey:'value',
					source:strMatchFunction(testSearch)
					});
});

</script>
</head>