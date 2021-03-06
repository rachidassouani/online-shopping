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
			   
			   <!-- Loading About content only if user clicks About-->
			   <c:if test="${userClicksAbout }">
					<%@include file="./about.jsp" %>
			   </c:if>
			   
			   <!-- Loading List Products content only if user clicks List Products or user clicks List Products by category-->
			   <c:if test="${userClicksAllProducts or userClicksShowProductsByCategory}">
					<%@include file="./listProducts.jsp" %>
			   </c:if>
			   
			   <!-- view a single product-->
			   <c:if test="${userClicksShowProduct}">
					<%@include file="./singleProduct.jsp" %>
			   </c:if>
			   
			    <!-- user clicks manage products-->
			   <c:if test="${userClicksManageProducts}">
					<%@include file="./manageProducts.jsp" %>
			   </c:if>
			  
		   </div>
			<!-- Footer -->
		    <%@include file="./shared/footer.jsp" %>
		
		    <!-- JQuery -->
		    <script src="${js }/jquery.js"></script>
		     <!-- Bootstrap -->
		    <script src="${js }/bootstrap.min.js"></script>   
		    
		    <script src="${js }/jquery.dataTables.min.js"></script>
		     
		    <script src="${js }/dataTables.bootstrap.min.js"></script>
		    
		    <!-- JS Code -->
		    <script src="${js }/app.js"></script>
		</div>
	</body>

</html>