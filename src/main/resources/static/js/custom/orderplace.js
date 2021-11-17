function getLastOrder(userId){
	$.ajax({
		type : "GET",
		contentType : "application/json; charset=utf-8",
		url : "/orders/lastOrder/"+userId,
		crossDomain : true,
		//dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("--response--",response) ;
             buildLastOrderSummary(response);   
		},
		error : function(xhr, status, error) {
			console.log("xhr",xhr);
		}
	});
}

function goToListOrder(userId){
	return  location.href ="/orderlist";
}