<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<div class="row">
	<c:if test="${not empty message }" >
		<div class="col-xs-12">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message }
			</div>
		</div>
	</c:if>
		
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form element -->
					<form:form 
							action="${contextRoot }/manage/products" 
							method="post" 
							modelAttribute="product" 
							enctype="multipart/form-data"
							class="form-horizontal">
						
						<div class="form-group">
							<label class="control-label col-md-4">Select an image: </label>
							<div class="col-md-8">
								<form:input type="file" path="file" id="file" class="form-control" />
								<form:errors path="file" cssClass="help-block"></form:errors >
							</div>
						</div>
							
						<div class="form-group">
							<label class="control-label col-md-4">Product Name: </label>
							<div class="col-md-8">
								<form:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<form:errors path="name" cssClass="help-block"></form:errors >
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Product brand: </label>
								<div class="col-md-8">
								<form:input type="text" path="brand" id="brand" placeholder="Product Brand Name" class="form-control" />
								<form:errors path="brand" cssClass="help-block"></form:errors >
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Product Description: </label>
								<div class="col-md-8">
								<form:textarea rows="4" cols="" path="description" id="description" placeholder="Product Description" class="form-control"></form:textarea>
								<form:errors path="description" cssClass="help-block"></form:errors >
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Product Price: </label>
								<div class="col-md-8">
								<form:input type="number" path="price" id="price" placeholder="Product Price" class="form-control" />	
								<form:errors path="price" cssClass="help-block"></form:errors >
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Product Quantity: </label>
								<div class="col-md-8">
								<form:input type="number" path="quantity" id="quantity" placeholder="Product Quantity" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Select Category: </label>
								<div class="col-md-8">
								<form:select 
										items="${categories }"
										itemLabel="name" 
										itemValue="id"
										path="categoryId" id="categoryId" class="form-control" />		
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="submit" class="btn btn-info" />
							</div>
						</div>
						
						<!-- Hidden fields -->
						<form:hidden path="id"/>
						<form:hidden path="code"/>
						<form:hidden path="active"/>
						<form:hidden path="supplierId"/>
						<form:hidden path="purchases"/>
						<form:hidden path="views"/>
						
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>