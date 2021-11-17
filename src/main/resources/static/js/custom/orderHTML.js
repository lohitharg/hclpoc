function buildOrderListTable(userId,orderList){
	var orderBlockContent=``;
	for (var i = 0; i <orderList.length; i++) {
		var productBlockContent=``;
		var products=orderList[i].productName;
		var productArr=products.split(",");
		var productPriceArr = orderList[i].price;
		var productPrice=productPriceArr.split(",");
		var cancelBtn=``;
		if(orderList[i].orderStatus!='Order Cancelled'){
		cancelBtn = `<button href="#" class="btn btn-warning" onclick="cancelOrder(`+orderList[i].order_id+`)"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z"/>
					  <path fill-rule="evenodd" d="M2.146 2.146a.5.5 0 0 0 0 .708l11 11a.5.5 0 0 0 .708-.708l-11-11a.5.5 0 0 0-.708 0Z"/>
					</svg> Cancel Order</button>`;
		}
orderBlockContent = orderBlockContent +`<div class="card-body">
            <h6>Order ID: `+orderList[i].order_id+`</h6>
            <article class="card">
                <div class="card-body row">
                    <div class="col"> <strong>Ordered On:</strong> <br>`+orderList[i].order_date+` </div>
                    <div class="col"> <strong>Delivery Address:</strong> <br>`+orderList[i].delivery_address+` </div>
                    <div class="col"> <strong>Status:</strong> <br> `+orderList[i].orderStatus+` </div>
                    <div class="col"> <strong>Payment Type:</strong> <br> `+orderList[i].payment_type+` </div>
                </div>
            </article>
            <div class="track">
                <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Order confirmed</span> </div>
                <div class="step active"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text"> Picked by courier</span> </div>
                <div class="step"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text"> On the way </span> </div>
                <div class="step"> <span class="icon"> <i class="fa fa-box"></i> </span> <span class="text">Ready for pickup</span> </div>
            </div>
            <hr>
            <ul class="row">`;
            for (var j = 0; j < productArr.length; j++) {
              productBlockContent=productBlockContent+ ` <li class="col-md-4">
                    <figure class="itemside mb-3">
                        <div class="aside"><img src="images/comingSoon.png" class="img-sm border"></div>
                        <figcaption class="info align-self-center">
                            <p class="title">`+productArr[j]+`</p> <span class="text-muted">`+productPrice[j]+` </span>
                        </figcaption>
                    </figure>
                </li>`;
                }
               
               
          orderBlockContent=orderBlockContent+ productBlockContent+ `</ul>
            <hr> `+cancelBtn+` <button class="btn btn-warning"onclick="orderInvoice(`+userId+`,`+orderList[i].order_id+`)">Get Invoice</button>
        </div>`;
        }
	  $("#orderBlock").html('');
	$("#orderBlock").html(orderBlockContent);
}




$(document).ready(function () {
	
	listorders(1);
	});