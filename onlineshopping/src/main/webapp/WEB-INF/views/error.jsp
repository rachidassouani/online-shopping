<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>


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
			window.menu = "${title}";
			window.contextRoot = "${contextRoot}";
		</script>
	
		<!-- Bootstrap Core CSS -->
	    <link href="${css }/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- Bootstrap readable theme CSS -->
	    <link href="${css }/bootstrap-readable-theme.css" rel="stylesheet">
	    
	    <!-- dataTables-->
	    <link href="${css }/dataTables.bootstrap.min.css" rel="stylesheet">	   
	
	    <link href="${css }/style.css" rel="stylesheet">
	
	</head>

	<body>
		<div class="wrapper">
		  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		    <div class="container">
		        <div class="navbar-header">
		           <a class="navbar-brand" href="${contextRoot }/home">Home</a>
		        </div>
		    </div>
		   </nav>
		   <div class="content">
		   	<div class="container">
		   		<div class="row">
		   			<div class="col-xs-12">
		   				<div class="jumbotron">
		   					<h1>${errorTitle }</h1>
		   					<hr>
		   					<blockquote>
		   						${errorDescription }
		   					</blockquote>
		   				</div>
		   			</div>
		   		</div>
		   	</div>
		   
		   </div>
	     </div>
			<!-- Footer -->
		    <%@include file="./shared/footer.jsp" %>
		
	</body>
</html>