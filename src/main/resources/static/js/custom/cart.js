function addToCart(productId,userId,qty,price,productName){
	console.log("Inside add to cart");
	
	var cartBody = {};
				cartBody["productId"] = productId;
				cartBody["userId"]= userId;
				cartBody["qty"]= qty;
				cartBody["price"]=price;
				cartBody["productName"]=productName;
	
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		url : "/cart/add",
		data : JSON.stringify(cartBody),
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
			if (response == "Product added to cart successfully") {
                  //  alert("You will now be redirected.");
                  // location.href = "/cart";
                  $('#myModal').modal('show');
                }
                
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
} 

function checkout(userId){
	console.log("Inside checkout");
	
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		url : "/orders/checkout_order/"+userId,
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
			if (response == "Order created") {
                   // alert("order placed.");
                   location.href = "/orderplaced";
                }
                
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
} 

/**Internal use* */
function listCart(userId){
	console.log("Inside listCart");
	$.ajax({
		type : "GET",
		contentType : "application/json; charset=utf-8",
		url : "/cart/list/"+userId,
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
			buildCartTable(userId,response);
			
                
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
}