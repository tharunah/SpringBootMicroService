package com.example.rest;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharu on 11/13/2016.
 */
@Named
@Path("/")
public class CustomerRest {
    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Customer 1");
        customer1.setEmail("customer1@gmail.com");
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Customer 2");
        customer2.setEmail("Customer2 @gmail.com");
        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Customer 3");
        customer3.setEmail("Customer3 @gmail.com");
        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setName("Customer 4");
        customer4.setEmail("Customer4 @gmail.com");
        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setName("Customer 5");
        customer5.setEmail("Customer5 @gmail.com");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GET
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@QueryParam("id") int id) {
        Customer c = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                c = customer;
            }
        }
        return c;
    }

}
