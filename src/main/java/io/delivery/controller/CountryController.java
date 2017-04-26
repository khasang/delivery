package io.delivery.controller;

import io.delivery.model.CountryInfo;
import io.delivery.service.CountryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryClient countryClient;

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfo getCountyByCode(@PathVariable(value = "code") String code) {
        CountryInfo countryInfo = new CountryInfo();
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCountryByCode(code);
        countryInfo.setCountryCode(result.get("code"));
        countryInfo.setName(result.get("name"));
        return countryInfo;
    }

    @RequestMapping(value = "/{country}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfo countryInfo(@PathVariable("country") String country) {
        CountryInfo countryInfo = new CountryInfo();
        HashMap<String, String> result = (HashMap<String, String>) countryClient.currencyInfo(country);
        countryInfo.setName(result.get("name"));
        countryInfo.setCurrency(result.get("curency"));
        return countryInfo;
    }
}
