package io.delivery.controller;

import io.delivery.entity.NoRegistrationCustomer;
import io.delivery.service.NoRegistrationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/noregistration")
public class NoRegistrationCustomerController {
    final private NoRegistrationCustomerService noRegistrationCustomerService;

    @Autowired
    public NoRegistrationCustomerController(NoRegistrationCustomerService noRegistrationCustomerService) {
        this.noRegistrationCustomerService = noRegistrationCustomerService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<NoRegistrationCustomer> getNoRegistrationCustomerList() {
        return noRegistrationCustomerService.getNoRegistrationCustomerList();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<NoRegistrationCustomer> getNoRegistrationCustomerByName(@PathVariable(value = "name") String name) {
        return noRegistrationCustomerService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public NoRegistrationCustomer addNoRegistrationCustomer(@RequestBody NoRegistrationCustomer noRegistrationCustomer) {
        noRegistrationCustomerService.create(noRegistrationCustomer);
        return noRegistrationCustomer;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;UTF-8")
    @ResponseBody
    public NoRegistrationCustomer updareNoRegistrationCustomer(@RequestBody NoRegistrationCustomer noRegistrationCustomer) {
        noRegistrationCustomerService.update(noRegistrationCustomer);
        return noRegistrationCustomer;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public NoRegistrationCustomer deleteNoRegistrationCustomer(@PathVariable(value = "id") String inputId) {
        return noRegistrationCustomerService.deleteNoRegistrationCustomer(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  NoRegistrationCustomer getNoRegistrationCustomerById(@PathVariable(value = "id") String id){
        return  noRegistrationCustomerService.findById(Long.parseLong(id));
    }
}





