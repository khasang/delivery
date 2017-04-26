package io.delivery.controller;

import net.webservicex.CountryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryClient countryClient;

    @RequestMapping(value = "")
    public String country() {
        return "country";
    }
    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    public ModelAndView getCountyByCode(@PathVariable(value = "code") String code) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country");
        modelAndView.addObject("result", countryClient.getCountryByCode(code));
        return modelAndView;
    }
}
