<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>


<c:set var="contextRoot" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Online Shopping - ${title}</title>
	
		<script>
			window.menu = "${title}"
		</script>
	
		<!-- Bootstrap Core CSS -->
	    <link href="${css }/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- Bootstrap readable theme CSS -->
	    <link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">
	
	    <link href="${css }/style.css" rel="stylesheet">
	
	</head>

	<body>
	
		<div class="wrapper">
		    <!-- Navigation -->
			<%@include file="./shared/navbar.jsp" %>
			
		   <!-- Page Content -->
		   <div class="content">
			   <!-- Loading home content only if user clicks home-->
			   <c:if test="${userClicksHome }">
					<%@include file="./home.jsp" %>
			   </c:if>
			   
			   <!-- Loading contact content only if user clicks contact-->
			   <c:if test="${userClicksContact }">
					<%@include file="./contact.jsp" %>
			   </c:if>
			   
			   <!-- Loading List Products content only if user clicks List Products-->
			   
			   
			   <!-- Loading About content only if user clicks About-->
			   <c:if test="${userClicksAbout }">
					<%@include file="./about.jsp" %>
			   </c:if>
		   </div>
			<!-- Footer -->
		    <%@include file="./shared/footer.jsp" %>
		
		    <!-- JQuery -->
		    <script src="${js }/jquery.js"></script>
		     <!-- Bootstrap -->
		    <script src="${js }/bootstrap.min.js"></script>
		    
		    <!-- JS Code -->
		    <script src="${js }/app.js"></script>
		</div>
	</body>

</html>