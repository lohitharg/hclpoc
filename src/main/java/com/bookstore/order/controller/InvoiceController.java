package com.bookstore.order.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookstore.order.entity.OrderDetails;
import com.bookstore.order.service.OrderService;

/**
 * @author Apurva Patel
 *
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {


    @Autowired
    private RestTemplate restTemplate;
   
    @Autowired
	private OrderService orderService;

    /*public OrderDetails fetchOrderDetails(Long userid,String order_id) 
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<OrderDetails> response =restTemplate.exchange("http://azuredeploytrial.azurewebsites.net/orders/list/1/"+order_id,
                                                          HttpMethod.GET,new HttpEntity<>(headers),OrderDetails.class);
        OrderDetails order=response.getBody();
          return order;

    }*/

    @RequestMapping(value = "/order/generateInvoice/{userid}/{orderid}", method = RequestMethod.GET)

    public File getInvoice(@PathVariable("userid") Long userid, @PathVariable("orderid") String orderId) {
          File file = null;
          try {
                 //file = new File("C://Invoice/Invoice_"+orderId+".pdf");
                 // File file = new File("https://bookinvoice.file.core.windows.net/invoice/Invoice_"+orderId+".pdf");
                 file = File.createTempFile("Invoice_" + orderId, ".pdf");
                 OrderDetails order = orderService.getOrderByOrderId(userid,orderId);
                // OrderDetails order = fetchOrderDetails(userid, orderId); // TODO :Can be replaced with above code once this method
                 HttpHeaders headers = new HttpHeaders();
                 HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(order, headers);
                 byte[] output = restTemplate.postForObject("http://localhost:9011/invoice/placeOrder", entity,byte[].class);
                 OutputStream os= new FileOutputStream(file);
                 os.write(output);
                 //logger.info("Successfully bytes inserted");
                 os.close();

          } catch (Exception e) {
                 //logger.error("Exception in getInvoice {}",e.getMessage());

          }
          return file;
    }     

}