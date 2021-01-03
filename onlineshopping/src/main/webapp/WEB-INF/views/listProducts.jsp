<div class="container">
	<div class="row">
		<!-- To display sidebar -->
		<div class="col-md-3">		
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<!-- To display products -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClicksAllProducts}" >	
						<script>
							window.categoryCode = '';
						</script>
						
						<ol class="breadcrumb">
							<li> <a href="${contextRoot }/home">Home</a> </li>
							<li class="active">All Products</li>
						</ol>	
					</c:if>
					<c:if test="${userClicksShowProductsByCategory}" >	
						<script>
							window.categoryCode = '${category.code}';
						</script>
						
						<ol class="breadcrumb">
							<li> <a href="${contextRoot }/home">Home</a> </li>
							<li class="active">Category</li>
							<li class="active">${category.name }</li>
						</ol>	
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable" class="table table-striped table-borderd">
						<thead>
							<tr> 
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						 </thead>
						
					
						 <tfoot>
							<tr> 
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						 </tfoot>
					</table>
						
				</div>
			
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
	</div>
</div>