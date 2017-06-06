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
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right m-right">
                <a class="search-icon"
                   data-ng-click="toggleInput()"
                   data-ng-show="!isSearchClicked"
                   href=""><i class="glyphicon glyphicon-search"></i></a> <input id="searchWordsTxt" data-ng-blur="toggleInput()"
					data-ng-class="{'expanded': isSearchClicked}" type="text"
					class="form-control search-input" placeholder="{{test}}" name="searchWords">
			</form>
        </div>
    </div>
</nav>