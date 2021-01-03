<div class="container">
	<!-- BreadCrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot }/home">Home</a></li>
				<li><a href="${contextRoot }/show/all/products">Products</a></li>
				<li class="active">${product.name }</li>
			</ol>
		</div>
	</div>
	
	<div class="row">
		<!-- Display the product Image -->
		<div class="col-xs-12 col-sm-4">
			to show image later...
		</div>
		
		<!-- Display the product description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name }</h3>
			<hr>
			
			<h4>Price: <strong> &#8377 ${product.price }</strong></h4>
			<hr>
			
			<p>${product.description }</p>
			<hr>
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Quantity Available: <span style="color:red">Out of stock</span></h6>
				</c:when>
				<c:otherwise>
					<h6>Quantity Available: ${product.quantity}</h6>
				</c:otherwise>
				
			</c:choose>
			<hr>
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a  href="javascript:void(0)" 
						class="btn btn-success disabled"><strike>
						<span class="glyphicon glyphicon-shopping-cart"></span>
						 add to cart</a></strike>
				</c:when>
				<c:otherwise>
					<a  href="${contextRoot }/cart/add/${product.code}/product" 
						class="btn btn-success">
						<span class="glyphicon glyphicon-shopping-cart"></span>
						add to cart</a>
				</c:otherwise>
				
			</c:choose>
					
			<a  href="${contextRoot }/show/all/products" 
			class="btn btn-warning">
			<span class="glyphicon glyphicon-chevron-left"></span>
			back</a>
			
		</div>
	</div>
</div>