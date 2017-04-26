package io.delivery.controller;

import io.delivery.model.CountryInfo;
import net.webservicex.CountryClient;
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
    @Autowired
    private CountryInfo countryInfo;

    @RequestMapping(value = "")
    public String country() {
        return "country";
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfo getCountyByCode(@PathVariable(value = "code") String code) {
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCountryByCode(code);
        countryInfo.setCountryCode(result.get("code"));
        countryInfo.setName(result.get("name"));
        return countryInfo;
    }
}
