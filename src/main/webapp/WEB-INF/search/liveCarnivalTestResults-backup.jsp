<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


	
		<section class="body-search-results">
		
		<form id="pageSearchForm" name="pageSearchForm" action="<c:out value='${baseURL}${searchModel["keywordSearch"]}'/>" method="post" target="">
		<!--End Header Area-->

		<div >
			
			<div >

				<p >
					<fmt:message key="SearchPhrase.msg">
						<fmt:param value="${searchModel['currentSearch'].searchPhrase}"></fmt:param>
					</fmt:message>
					<fmt:formatNumber value="${searchModel['currentSearch'].resultSetSize}"></fmt:formatNumber>
					Results
				</p>

	




			</div>

			<!--End Content Area-->
			<div >
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
	</section>
	
	
	

	
