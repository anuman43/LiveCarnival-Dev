<%@page session="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
<!--

//-->
	var recentSearchStr;
	recentSearchStr = '<c:out value="${searchModel['trending']}"/>';
</script>

<body>
<div id="wrapper">
<div id="header">
<nav id="nav" role="navigation">
    <a href="#nav" title="Show navigation"><font color="white">Menu</font></a>
    <a href="#" title="Hide navigation"><font color="white">Hide navigation</font></a>
    <ul>
        <li><a href="/"><font color="#bf6a0c">WEB</font></a></li>
        <li>
            <a href="/" aria-haspopup="true">IMAGES</a></li>
           <LI> <a href="/" >VIDEOS</a></li>
         
            <li> <a href="/" >MAPS</a></li>
            <li> <a href="/" >NEWS</a></li>
            <li> <a href="/" >SEARCH HISTORY</a></li>
        <li>
            <a href="/" aria-haspopup="true">MORE <span><img src="${baseURL}/resources/images/dropdown.png" style="border:none !important;"/></span></a>
            
        </li>
       
    </ul>
</nav>
<div id="right_header">
<p id="signin"><a href=""><font color="white">Sign in </font><span><img src="${baseURL}/resources/images/dropdown.png" style="border:none !important;"/></span></a></p>
<p id="round_button"></p>
</div>
</div>
<div id="container">
<div id="inner">
				<div id="carousel" style="width:100%;">
					<img src="${baseURL}/resources/images/container.png" alt="rally1" height="680px" border="0" />
					<img src="${baseURL}/resources/images/slider-img.png" alt="rally2"  height="680" border="0" />
					<img src="${baseURL}/resources/images/container.png" alt="rally3"  height="680" border="0" />
					<img src="${baseURL}/resources/images/slider-img.png" alt="rally4"  height="680" border="0" />
				</div>
				<div id="navi">
					
				</div>
			</div>
			

<div id="new_vertical">
<p id="vertical_banner"></p>
<div id="results">

	<c:choose>
	
		<c:when test="${not empty searchModel['mainSearch']}">

							<c:forEach var="result" items="${searchModel['mainSearch']}">
							
								<h4>Search result</h4><a href='<c:out value="${result.resultUrl}"/>'><c:out value="${result.resultPageTitle}"></c:out></a>

							</c:forEach>


						</c:when>
		<c:otherwise>

							<fmt:message key="NoResults.msg"/>

						</c:otherwise>
	
	</c:choose>
	

</div>
<div id="second_banner">
<p id="travel"></p>
<p id="ticket"></p>
<p id="news"></p>
</div>
</div>
</div>



</div>