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
});