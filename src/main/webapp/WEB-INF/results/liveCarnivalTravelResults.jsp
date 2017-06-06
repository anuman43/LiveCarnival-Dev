<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- Boolean to hold segment count expression --%>

<c:set var="segmentsVar" value="{0}"/>
<c:set var="carriersVar" value="A" scope="page"/>
<c:set var="segDuration" value="{0}"></c:set>


<div class="container">

	<hgroup class="mb20">
		<h1>Travel Search Results</h1>
		<h2 class="lead"><strong class="text-danger"><fmt:message key="Travel.Search.msg"><fmt:param value="${searchModel['travelItinerary']}"></fmt:param></fmt:message></strong>&nbsp;<fmt:formatNumber value="${searchModel['travelSolutions']}"/> results<strong class="text-danger">
						
					</strong>
					</h2>								
	</hgroup>
	
		
		<c:choose>
			
			<c:when test="${searchModel['travelSolutions'] ne null}">
				<div class="container">
					<div class="col-lg-5">
						<table class="table">
							<thead>
								<tr>
									<td>Price</td>
									<td>Airline/s</td>
									<td>Duration</td>
									<td>Stops</td>
								</tr>
							</thead>
			<!-- Outter loop iterates through all results -->
				<c:forEach items="${searchModel['travelSearchResults'].tripResults}" var="trip">
					<tbody>
						<tr>
							<td><c:out value="${trip.tripCost}"></c:out></td>
							<!-- Loop through trip Segments -->
							<c:set var="segmentsVar" value="${fn:length(trip.tripSegments)}" scope="page"/>
							
							<c:choose >
								
									<c:when test="${segmentsVar > 0 }">
									
										<c:forEach items="${trip.tripSegments}" var="segment" varStatus="segstatus">
								
								
											<c:set var="carriersVar" value="${segment.airCarrier}"/>
								
								
											<c:forEach items="${segment.segLegList}"  var="Data" >
												
												<c:set var="segDuration" value="${Integer.valueOf(segDuration) += Integer.valueOf(Data.tripDuration)}"></c:set>
												
											</c:forEach>
											
											
										</c:forEach>
										
										
										
									
									</c:when>
									
									<c:otherwise>
										<c:set var="carriersVar" value="No Carrier"/>
										<td><h1><c:out value="${carriersVar}"/></h1></td>
									</c:otherwise>
								
								</c:choose>
							
							
							
							<td><c:out value="${carriersVar}"/></td>
								<td><c:out value="${segDuration}"/></td>
								<td><c:out value="${fn:length(segment.segLegList)}"></c:out></td>
						</tr>
											
					</tbody>
					<c:set var="segDuration" value="{Integer.valueOf(0)}"/>
				
				</c:forEach>
						
						</table>
					</div>
				</div>
						
			</c:when>
			
			<c:otherwise>
			
				
			
			</c:otherwise>
		</c:choose>
		
	<%-- <c:choose>
		<c:when test="${not empty searchModel['mainSearch']}">
			<c:forEach var="result" items="${searchModel['mainSearch']}">
			    <section class="col-xs-12 col-sm-6 col-md-12">
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
				</section>
	</c:forEach>
		</c:when>
		<c:otherwise>

				<fmt:message key="NoResults.msg" />

			</c:otherwise>
</c:choose><hgroup class="mb20">
		<h1>Search Results</h1>
		<h2 class="lead"><strong class="text-danger"><fmt:message key="SearchPhrase.msg"><fmt:param value="${searchModel['currentSearch'].searchPhrase}"></fmt:param></fmt:message><fmt:formatNumber value="${searchModel['currentSearch'].resultSetSize}"></fmt:formatNumber></strong> results<strong class="text-danger">
						
					</strong></h2>								
	</hgroup>
	<c:choose>
		<c:when test="${not empty searchModel['mainSearch']}">
			<c:forEach var="result" items="${searchModel['mainSearch']}">
			    <section class="col-xs-12 col-sm-6 col-md-12">
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
				</section>
	</c:forEach>
		</c:when>
		<c:otherwise>

				<fmt:message key="NoResults.msg" />

			</c:otherwise>
</c:choose>

 --%>

</div>