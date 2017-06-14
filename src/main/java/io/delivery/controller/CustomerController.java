package io.delivery.controller;

import io.delivery.entity.Customer;
import io.delivery.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    final private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByName(@PathVariable(value = "name") String name){
        return customerService.getCustomerByName(name);
    }

    @RequestMapping(value = "/get/email/{eMail}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByEmail(@PathVariable(value = "eMail") String eMail){
        return customerService.getCustomerByEmail(eMail);
    }

    @RequestMapping(value = "/get/phone/{phoneNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber){
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/get/address/{address}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomerByAddress(@PathVariable(value = "address") String address){
        return customerService.getCustomerByAddress(address);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerById(@PathVariable(value = "id") String id){
        return customerService.getCustomerById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Customer deleteCustomerById(@PathVariable(value = "id") String id){
        return customerService.deleteCustomer(Long.parseLong(id));
    }

    @RequestMapping(value = "/send/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView sendCustomer(@PathVariable(value = "id") String id){
        customerService.sendCustomerInfo(customerService.getCustomerById(Long.parseLong(id)));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customerSend");
        return modelAndView;
    }

    @RequestMapping(value = { "/newCustomer" }, method = RequestMethod.GET)
    public String prepareOrder(ModelMap model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer";
    }
}
