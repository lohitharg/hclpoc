
function orderInvoice(userId,orderId){
	$.ajax({
             type : "GET",
             contentType : "application/pdf; charset=utf-8",
             url : "/invoice/order/generateInvoice/"+userId+"/"+orderId,
             crossDomain : true,
             //dataType : 'pdf',
             timeout : 100000,
             responseType:ArrayBuffer,
             success : function(response) {
                    window.open(response, '_blank');
             },
             error : function(xhr, status, error) {
                    console.log("xhr",xhr);
             }
           });
}