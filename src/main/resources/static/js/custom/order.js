function listorders(userId){
	console.log("Inside listOrders");
	$.ajax({
		type : "GET",
		contentType : "application/json; charset=utf-8",
		url : "/orders/list/"+userId,
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
			//if (response == "Order created") {
               //     alert("order placed.");
                   //location.href = "/orderlist";
               // }
             buildOrderListTable(userId,response);   
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
}


function cancelOrder(order_id){
	$.ajax({
		type : "PUT",
		contentType : "application/json; charset=utf-8",
		url : "/orders/cancel/"+order_id,
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
			 $('#cancelModal').modal('show');
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
}



