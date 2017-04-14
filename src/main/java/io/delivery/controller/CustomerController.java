package io.delivery.controller;

import io.delivery.entity.Customer;
import io.delivery.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    final private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByName(@PathVariable(value = "name") String name){
        return customerService.findCustomerByName(name);
    }

    @RequestMapping(value = "/get/eMail/{eMail}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByEmail(@PathVariable(value = "eMail") String eMail){
        return customerService.findCustomerByEmail(eMail);
    }

    @RequestMapping(value = "/get/phoneNumber/{phoneNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber){
        return customerService.findCustomerByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/get/address/{address}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByAddress(@PathVariable(value = "address") String address){
        return customerService.findCustomerByAddress(address);
    }

    @RequestMapping(value = "/get/idOrder/{idOrder}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByIdorder(@PathVariable(value = "idOrder") String idOrder){
        return customerService.findCustomerByIdOrder(Long.parseLong(idOrder));
    }





}
