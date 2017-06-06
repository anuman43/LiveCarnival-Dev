<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">

	<div class="row">
	
	<!-- Outer left column -->
      		<div class="col-md-2"></div>
      		
    <!-- inner content column -->
      		<div class="col-md-8">  		

    <hgroup class="mb20">
		<h1>Search Results</h1>
		<h2 class="lead"><strong class="text-danger"><fmt:message key="SearchPhrase.msg"><fmt:param value="${searchModel['currentSearch'].searchPhrase}"></fmt:param></fmt:message>&nbsp;<fmt:formatNumber value="${searchModel['currentSearch'].resultSetSize}"></fmt:formatNumber></strong>&nbsp; results<strong class="text-danger">
						
					</strong></h2>								
	</hgroup>
	<c:choose>
		<c:when test="${not empty searchModel['mainSearch']}">
			<c:forEach var="result" items="${searchModel['mainSearch']}">
			   <%--  <section class="col-xs-12 col-sm-6 col-md-12">
					<article class="search-result row">
						<div class="col-xs-12 col-sm-12 col-md-3">
							<a href="#" title="Lorem ipsum" class="thumbnail"><img src="http://lorempixel.com/250/140/people" alt="Lorem ipsum" /></a>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-2">
							<ul class="meta-search">
								<li><i class="glyphicon glyphicon-calendar"></i> <span>02/15/2014</span></li>
								<li><i class="glyphicon glyphicon-time"></i> <span>4:28 pm</span></li>
								<li><i class="glyphicon glyphicon-tags"></i> <span>People</span></li>
							</ul>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-7 excerpet">
							<h3><a href="<c:out value="${result.resultUrl}"/>" title=""><c:out value="${result.resultPageTitle}"></c:out></a></h3>
							<p><c:out value="${result.resultUrl}"/></p>						
			                <span class="plus"><a href="#" title="Lorem ipsum"><i class="glyphicon glyphicon-plus"></i></a></span>
						</div>
						<span class="clearfix borda"></span>
					</article>
				</section> --%>
				<div class="list-group">
					<h3><a href="<c:out value="${result.resultUrl}"/>" title=""><c:out value="${result.resultPageTitle}"></c:out></a></h3>
						<span><c:out value="${result.resultSnippet}"/></span>
<!-- 						<p><c:out value="${result.resultUrl}"/></p> -->
<!-- 					 <span class="plus"><a href="#" title="Lorem ipsum"><i class="glyphicon glyphicon-plus"></i></a></span> -->
<!-- 					<span><c:out value="${result.resultSnippet}"/></span> -->
					
				
				<%-- <c:forEach var="thumbs" items="${result.thumbList}">
				
					<div class="row">
						<div class="col-xs-6 col-md-3">
							<a href="#" class="thumbnail"></a>
								<img alt="" src="<c:out value='${thumbs.src}'/>" width="<c:out value='${thumbs.width}'/>" height="<c:out value='${thumbs.height}'/>"> 
						
						</div>
				
				</div>
				
				</c:forEach> --%>
				</div>
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
			
			<!-- outer right column -->
      		<div class="col-md-2"></div>
				
	</div>				

</div>