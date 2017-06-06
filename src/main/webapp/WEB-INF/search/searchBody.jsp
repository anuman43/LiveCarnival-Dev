
<script type="text/javascript">

	function verifyKeyWordsLgnth(form)
	{
			if(document.searchFrm.searchWords.value != null || document.searchFrm.searchWords.value.length > 1)
				return true;
				else
					return false;
		}


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
<div id="search_bar">

<div id="second_banner">
<p id="travel"></p>
<p id="ticket"></p>
<p id="news"></p>
</div>
</div>
</div>
			<form action="${baseURL}/Carnivate/cseResults" method="post" name="searchFrm">
				<input type="text" id="searchWordsTxt" name="searchWords" /> <input
					type="submit" id="searchBtn" name="searchBtn" value="submit"
					onclick="verifyKeyWordsLgnth(this)" /> &nbsp;<input type="reset"
					value="clear">
			</form>
		</div>


</div>