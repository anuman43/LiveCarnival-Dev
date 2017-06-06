<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="row"><br></div>
	<div class="row"><br></div>	
	<div class="row"><br></div>
	
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-4">
	
		 <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Events</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">View Events <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<c:out value="${eventsByDateUrl}"/>">By Date</a></li>
                <li><a href="<c:out value="${eventsByCarnival}"/>">By Carnival</a></li>
                <li><a href="#">By Location</a></li>
                <li role="separator" class="divider"></li>
                
              </ul>
            </li>
            <li class="dropdown">
            	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage Events <span class="caret"></span></a>
          			<ul class="dropdown-menu">
          				<li><a  href="#">Sign Up</a></li>
          				<li><a  href="http://tickets.livecarnival.com/">Login</a></li>
          				<li><a  href="http://tickets.livecarnival.com/submit-event">Create an Event</a></li>
          				<li><a  href="#">View My Events</a></li>
          				<li><a  href="#">Manage My Events</a></li>
          			</ul>
          		</li>
          		
          		 <li class="dropdown">
            	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">FAQ <span class="caret"></span></a>
          			<ul class="dropdown-menu">
          				<li><a  href="#">How it works</a></li>
          				<li><a  href="#">What are our fees</a></li>
          				<li><a  href="#">How to manage refunds</a></li>
          			</ul>
          		</li>
          		
          </ul>
          
        </div>
      </div>
    </nav>
	
	</div>
	
    	
    	
	
	
	</div>
		
	<div class="row">
		<!-- Content Column -->
	<div class="col-md-10">
	
		<h2 class="text-center">Live Carnival Events</h2>
	
			<!-- Events table -->
		<table class="table">

					<thead class="thead-inverse">
						<tr>
							<th align="justify">#</th>
							<th>Date</th>
							<th><span class="glyphicon glyphicon-picture"></span></th>
							<th>Event Name</th>
							<th>Location</th>
							
						</tr>

					</thead>

					<tfoot>
   					<tr>
   						<td class="text-center">View All Events</td>
   					</tr>
   				</tfoot>
   				<tbody>
				<c:forEach var="eventColItem" items="${searchModel['allEvents']}"
					varStatus="eventCount">
					<tr>
						<td><c:out value="${eventCount.count}"></c:out></td>
						<td><c:out value="${eventColItem.eventStartDate}"/></td>
						<td><img alt=""
							src="<c:out value='${eventColItem.eventImageLocation}'/>"></td>
						<td><a href="<c:out value='${eventColItem.eventUri}${eventColItem.eventTitle}'/>"><c:out value="${eventColItem.eventTitle}"></c:out></a></td>
						<td><c:out value="${eventColItem.eventLocation}"></c:out></td>
						
					</tr>
				</c:forEach>

			</tbody>
   			
   			</table>
	


	</div>
	
	</div>


	
<div class="row"><br></div>
</div>
	