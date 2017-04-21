package io.delivery.controller;

import io.delivery.entity.NoRegistrationCustomer;
import io.delivery.service.NoRegistrationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping ("/noRegistrationCustomer")
public class NoRegistrationCustomerController {
    final private NoRegistrationCustomerService noRegistrationCustomerService;

    @Autowired
    public NoRegistrationCustomerController (NoRegistrationCustomerService noRegistrationCustomerService){
        this.noRegistrationCustomerService = noRegistrationCustomerService;
    }
    @RequestMapping(value = "/allnoregistrationcustomer",method = RequestMethod.GET)
    @ResponseBody
    public List<NoRegistrationCustomer> getNoRegistrationCustomerList(){
        return noRegistrationCustomerService.getNoRegistrationCustomerList();
    }
}
