<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<body>
	<form id="pageSearchForm" name="pageSearchForm" action="<c:out value='${baseURL}${searchModel["keywordSearch"]}'/>" method="post" target="">
		<div class="header_area fix ">
			<div class="header_bottom fix">
				<div class="header_bottom_menu fix  float_left">
					<img class="menu-icon"
						src="${baseURL}/resources/images/menu-icon.png"
						alt="Click to expand menu" />
					<ul class="nav-list">
						<li><a href="">Web</a></li>
						<li><a href="">Images</a></li>
						<li><a href="">videos</a></li>
						<li><a href="">News</a></li>
						<li><a href="">Search History</a></li>
						<li><a href="">More</a></li>
					</ul>
				</div>
				<div class="header_bottom_right fix float_right">
					<a href="" style="">Sign in<img
						src="${baseURL}/resources/images/6.png" alt=""> </a> <span
						class="setting"><a href=""><img
							src="${baseURL}/resources/images/8.png" alt=""> </a> </span>
				</div>
			</div>
			<div class="header fix structure">
				<div class="header_upper fix float_left">
					<div class="logo fix float_left">
						<img src="${baseURL}/resources/images/1.png" alt="">
					</div>
					<span class="fix search float_right">
						
							<input class="search_filed_fix" value="" type="text"
								name="searchWords" placeholder="Search" id="inlineResultTxt"> <span class="buttom"><input
								class="search_btn" type="submit" value="Search" name="searchBtn" onclick="newSearch()"
								id="searchResultBtn"> </span>
						 </span>
				</div>
			</div>
		</div>
		<!--End Header Area-->

		<div class="content_area fix">

			<div class="content fix">

				<p class="show_result fix">
					<fmt:message key="SearchPhrase.msg">
						<fmt:param value="${searchModel['currentSearch'].searchPhrase}"></fmt:param>
					</fmt:message>
					<fmt:formatNumber value="${searchModel['currentSearch'].resultSetSize}"></fmt:formatNumber>
					Results
				</p>

	<!--  
				<div class="search_option fix">

					<p class="search_link">
						<span class="search_link_color fix">nazmul81.weebly.com/index.html<a
							href="" class="arrow"><img style="margin-left: 3px"
								src="${baseURL}/resources/images/arrows_normal.png"> </a> </span>
					</p>
				</div>
-->




			</div>

			<!--End Content Area-->
			<div class="content fix">
				<c:choose>

					<c:when test="${not empty searchModel['mainSearch']}">

						<c:forEach var="result" items="${searchModel['mainSearch']}">
							<div class="search_option fix">
								<a href="<c:out value="${result.resultUrl}"/>"><strong><c:out
											value="${result.resultPageTitle}"></c:out> </strong> </a>
								<p class="search_link">
									<span class="search_link_color fix"><c:out
											value="${result.resultUrl}"></c:out><a
										href="<c:out value="${result.resultUrl}"/>" class="arrow"><img
											style="margin-left: 3px"
											src="${baseURL}/resources/images/arrows_normal.png"> </a> </span>
								</p>
							</div>

							<!--<h4>Search result</h4><a href='<c:out value="${result.resultUrl}"/>'><c:out value="${result.resultPageTitle}"></c:out></a>-->

						</c:forEach>


					</c:when>
					<c:otherwise>

						<fmt:message key="NoResults.msg" />

					</c:otherwise>


				</c:choose>
				<div class="pagination fix">
					<ul>
						<li class="images1 fix" onclick=""><a href=""><img
								src="${baseURL}/resources/images/5.png"> </a>
						</li>
					<c:choose>
						<c:when test="${not empty searchModel['mainSearch']}">
						<c:forEach var="page"
							begin="${searchModel['currentView'].viewRangeStart}"
							end="${searchModel['currentView'].viewRangeEnd}">
							
							<li class="common_li fix"><a
								onclick="return getResultsPage(<c:out
									value='${page}' />);"
								href="${baseURL}${searchModel['pagedSearchResults']}" id="page${page}">
								<c:choose>
									<c:when test="${searchModel['currentView'].currentPageIndex eq page}">
										<u><c:out
										value="${page}" /></u>
									</c:when>
									<c:otherwise><c:out
										value="${page}" /></c:otherwise>
								</c:choose>
								</a>
							</li>
							
						</c:forEach>
						
						
						</c:when>
						
					</c:choose>
						
						<li class="images2 fix"><a href="" class="images fix"><img
								src="${baseURL}/resources/images/4.png"> </a></li>

					</ul>
				</div>

			</div>
		</div>
	</form>
</body>