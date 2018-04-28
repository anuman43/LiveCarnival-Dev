<!-- Navigation -->
<nav data-ng-controller="HeaderController" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
    	
        <div class="navbar-header">
        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="${baseURL}/resources/images/logo.png" alt="logo" title=""></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
         	<form id="navbarSearchTxt" class="navbar-form navbar-right m-right" method="post" action="${baseURL}/Carnivate/cseResults">
         		<div class="form-group"> 
         			<div class="show" id="searchInputDiv">
     					<input type="text" id="searchTxt" name="searchWords">
     					<span class="glyphicon glyphicon-search" id="searchIdspan" aria-hidden="true"></span>
     				</div>
         		        		
         		</div>
         	
         	
         	
         	</form>
        </div><!--/.nav-collapse -->
      </div>
</nav>