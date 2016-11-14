package com.example.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by tharu on 11/13/2016.
 */
@Named
@Path("/")
public class OrderRest {
    private static int id = 1;

    @Autowired
    RestTemplate restTemplate;

    @GET
    @Path("order")
    @Produces(MediaType.APPLICATION_JSON)
    public Order submitOrder(@QueryParam("customerId") int customerId, @QueryParam("productId") int productId, @QueryParam("amount") long amount) {
        Order order = new Order();
        Customer customer = restTemplate.getForObject("http://localhost:9002/customer?id={id}", Customer.class, customerId);
        Product product = restTemplate.getForObject("http://localhost:9001/product?id={id}", Product.class, productId);
        ;

        order.setId(id);
        order.setAmount(amount);
        order.setCustomer(customer);
        order.setProduct(product);
        order.setOrderDate(new Date());

        id++;

        return order;
    }
}
