<!-- Hotel or Accomodation search results listing -->
<%@include  file="../search/taglibInclude.jsp" %>



<div class="container">

	<hgroup class="mb20">
		<h1><fmt:message key="Hotel.Results.msg"/></h1>
		<h2 class="lead"><strong class="text-danger"><fmt:message key="Hotel.Results.msg"></fmt:message></strong>&nbsp;<fmt:formatNumber value="${fn:length(searchModel['hotelsList'])}"/> results<strong class="text-danger">
						
					</strong>
					</h2>								
	</hgroup>
	
		<!-- NB Only other jsp tags allowed inside of c:choose -->
		<c:choose>
						
		<c:when test="${not empty searchModel['hotelsList']}">
		
			 <div class="row">
  			
  			<div class="col-lg-2">
  			
  			
  			</div>	
			
				<div class="col-lg-8">
						<table class="table">
							<thead>
								<tr>
		  							<td></td>
		  							<td>Hotel Name</td>
		  							<td>Location</td>
		  							<td>Rate- High/Low</td>
		  							<td>Description</td>
		  							<td>Book/Reserve Rooms</td>
  								</tr>
							</thead>

						<c:forEach items="${searchModel['hotelsList']}" var="hotelsList"
							varStatus="itemStatus" begin="${searchModel['accomodationListStart']}" end="${searchModel['accomodationListEnd']}">
							<tbody>

								<tr>
									<td><c:out value="${itemStatus.count}" /></td>
									<td><c:out value="${hotelsList.name}" /></td>
									<td><c:out value="${hotelsList.address1}" /></td>
									<td><c:out value="${hotelsList.highRate}" />/<c:out
											value="${hotelsList.lowRate}" /></td>
									<td><c:out value="${hotelsList.locationDescription}" /></td>
									<td><button class="btn btn-primary">Reserve/Book</button></td>
								</tr>

							</tbody>


						</c:forEach>

					</table>
					</div>
				</div>
				<div class="col-lg-2">
  			
  			
  				</div>
				
			</c:when>
			
			<c:otherwise>
			
				
					<div class="col-lg-5">
						<h4>No hotels matching your search found</h4>
					
					</div>
			
			</c:otherwise>
		</c:choose>
		
		<nav aria-label="Navigation">
		
			<ul class="pagination">
				
				<li>
		      <a href="${baseURL}${searchModel['scrollHotelResults']}?iteration=${searchModel['currentIteration'] - 1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		     	 </a>
		    	</li>
		   	
			<c:forEach begin="1" items="${searchModel['hotelsList']}" step="10"
				varStatus="paginationStatus" end="${fn:length(searchModel['hotelsList'])}">
					<c:choose>
						<c:when test="${paginationStatus.count eq searchModel['currentIteration']}">
							<li class="active"><a href="${baseURL}${searchModel['scrollHotelResults']}?iteration=${paginationStatus.count}"><c:out value="${paginationStatus.count}"></c:out></a></li>
						</c:when>
						<c:otherwise>
							<li ><a href="${baseURL}${searchModel['scrollHotelResults']}?iteration=${paginationStatus.count}"><c:out value="${paginationStatus.count}"></c:out></a></li>
						
						</c:otherwise>
					</c:choose>
				
			</c:forEach>
				<li><a href="${baseURL}${searchModel['scrollHotelResults']}?iteration=${searchModel['currentIteration'] + 1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
	   			 </li>
			
			
			</ul>
		
		
		</nav>
		
</div>