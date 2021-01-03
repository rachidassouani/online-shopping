$(function() {
	// for active menu
	switch(menu) {
		case 'About us': 
			$('#about').addClass('active'); 
			break;
		
		case 'Contact us': 
			$('#contact').addClass('active'); 
			break;
		
		case 'list Products': 
			$('#listProducts').addClass('active'); 
			break;
		
		default: 
			$('#listProducts').addClass('active'); 
			$('#c_'+menu).addClass('active');
			break;		
	}
		
	
	let table = $('#productListTable');
	
	
	var jsonUrl = '';
	if (table.length) {
		if (window.categoryCode == '') {
			jsonUrl = window.contextRoot + '/api/products';
			
		} else {
			jsonUrl = window.contextRoot + '/api/categories/' + window.categoryCode + '/products';
		}
		
		
		table.DataTable({
			lengthMenu : [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All']],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{data : 'name'},
				{data : 'brand'},
				{data : 'price', mRender: (data, type, row) => '&#8377;' + data	},
				{data : 'quantity', mRender: (data, type, row) => {
					if (data < 1 ) {
						return '<span style="color: red">Out of stock!</span>';
					}
					return data;
				}},
				{	data: 'code',
					bSortable: false,
					mRender: function(data, type, row) {
					let str= '';
					str += `<a href="${window.contextRoot}/show/${data}/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160`;
					
					if(row.quantity < 1) {
						str += `<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>`;	
					} else {
						str += `<a href="${window.contextRoot}/cart/add/${data}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>`;	
					}
					return str;
				}}		
			] 
		});		
	}
});