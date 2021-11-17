function buildCartTable(userId,cartProducts){
	var cartTableContent=``;
	if(cartProducts.length==0){
		 cartTableContent=`<span>No Books added to Cart</span>`;
	}
	else{
		var cartTableHeader=`<table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" class="text-white">Product</th>
                            <th scope="col" class="text-white">Price</th>
                            <th scope="col" class="text-white">Quantity</th>
                            <th scope="col" class="text-white">Total</th>
                        </tr>
                    </thead>
                    <tbody>`;
     var cartRowContent=``;   
     var subTotal=0;            
	for (var i = 0; i < cartProducts.length; i++) {
		var productName = cartProducts[i].productName;
		var price = cartProducts[i].price;
		var qty = cartProducts[i].qty;
		var TotalPrice=qty*price;
		subTotal=subTotal+price;
		cartRowContent = cartRowContent+`
                        <tr>
                            <td>
                                <div class="main">
                                    <div class="d-flex">
                     <!--W=145 H=98--> <img src="images/cart-1.jpg" alt="">
                                    </div>
                                    <div class="des">
                                        <p>`+productName+`</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <h6>`+price+`</h6>
                            </td>
                            <td>
                                <h6>`+qty+`</h6>
                            </td>
                            <td>
                                <h6>`+TotalPrice+`</h6>
                            </td>
                        </tr>`;
                        
		}
		var subTotalContent = buildSubTotal(subTotal);
		var checkoutBtn = buildCheckoutBtn(userId);
		 cartTableContent=cartTableHeader+cartRowContent+` </tbody></table>`+subTotalContent+checkoutBtn;
	}
	
	
                $("#cartTable").html('');
	$("#cartTable").html(cartTableContent);
}
function buildSubTotal(subTotal){
	return `<div class="" style="
    /* width: 100%!important; */
">
        <div class="" style="
    height: 50px;
    background-color: #343a40;
    border: none;
    color: white;
    width: 910px;
    border-color: #454d55;
    /* float: right; */
">
            <ul style="
    float: right;
">
                <li class="subtotal" style="
    font-weight: bold;margin-left: -148px;
">Subtotal
                    <span>`+subTotal+`</span>
                </li>
            </ul>
           
        </div>
    </div>`;
}
function buildCheckoutBtn(userId){
	  return `<div style="display: flex;justify-content: center;align-items: center;"><button onclick="checkout(`+userId+`)" class="btn btn-warning">Proceed to Checkout</button></div>`;

}

$(document).ready(function () {
	
	listCart(1);
	});