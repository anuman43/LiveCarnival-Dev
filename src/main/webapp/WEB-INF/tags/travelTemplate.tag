<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>


<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Live4Carnival</title>

    <!-- styles/vendors.css -->
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${baseURL}/resources/vendors/revslider-jquery/slider.css" media="screen" />

    <!-- styles/styles.css -->
    <link rel="stylesheet" href="${baseURL}/resources/styles/main.css"/>
    
    
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
                   href=""><i class="glyphicon glyphicon-search"></i></a>
                <input id="search-input"
                       data-ng-blur="toggleInput()"
                       data-ng-class="{'expanded': isSearchClicked}"
                       type="text" class="form-control search-input" placeholder="{{test}}">
            </form>
        </div>
    </div>
</nav>
<!-- Body -->
<div id="accomodationBody">
    <jsp:doBody/>
</div>

<!-- Footer -->
<section id="footer">
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-right">
                    <img src="${baseURL}/resources/images/logo-footer.png" align="logo">
                </div>
                <div class="col-sm-6 text-left">
                    Contact us:
                    <p>Email: <a target="_blank" href="mailto:info@live4carnival.com">info@live4carnival.com</a></p>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <h5>
            <span class="scroll-wrapper">
                <a id="back-to-top" href="#" style="display: none;"><i class="icon-arrow-up"></i></a>
                <small>Copyright Â© Live4Carnival. By <a target="_blank" href="http://glacegrafix.com/">GlaceGrafix Inc.</a></small>
            </span>
            </h5>
        </div>
    </div>
</section>
</body>