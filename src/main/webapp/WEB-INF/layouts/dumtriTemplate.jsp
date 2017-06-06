<%@ page session="true" contentType="text/html" import="java.util.*" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<tiles:insertAttribute name="header"/>
	
		<tiles:insertAttribute name="body"/>
	
		<tiles:insertAttribute name="footer"/>

