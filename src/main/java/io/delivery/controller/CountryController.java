package io.delivery.controller;

import io.delivery.model.CountryInfoContainer;
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
    public CountryInfoContainer getCountyByCountryCode(@PathVariable(value = "code") String code) {
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCountryByCountryCode(code);
        CountryInfoContainer countryInfoContainer = new CountryInfoContainer();
        countryInfoContainer.setCountryCode(result.get("code"));
        countryInfoContainer.setName(result.get("name"));
        return countryInfoContainer;
    }

    @RequestMapping(value = "/currency/{currencycode}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfoContainer getCountryByCurrencyCode(@PathVariable(value = "currencycode") String currencyCode) {
        CountryInfoContainer countryInfoContainer = new CountryInfoContainer();
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCountryByCurrencyCode(currencyCode);
        countryInfoContainer.setName(result.get("name"));
        countryInfoContainer.setCountryCode(result.get("code"));
        countryInfoContainer.setCurrency(result.get("curency"));
        countryInfoContainer.setCurrencyCode(result.get("curencycode"));
        return countryInfoContainer;
    }

    @RequestMapping(value = "/currency/name/{currencyname}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfoContainer getCountryByCurrency(@PathVariable(value = "currencyname") String currencyName) {
        CountryInfoContainer countryInfoContainer = new CountryInfoContainer();
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCountryByCurrency(currencyName);
        countryInfoContainer.setCurrency(result.get("curency"));
        countryInfoContainer.setCurrencyCode(result.get("curencycode"));
        return countryInfoContainer;
    }

    @RequestMapping(value = "/name/{country}", method = RequestMethod.GET)
    @ResponseBody
    public CountryInfoContainer getCurrencyByCountry(@PathVariable("country") String country) {
        CountryInfoContainer countryInfoContainer = new CountryInfoContainer();
        HashMap<String, String> result = (HashMap<String, String>) countryClient.getCurrencyByCountry(country);
        countryInfoContainer.setName(result.get("name"));
        countryInfoContainer.setCurrencyCode(result.get("curencycode"));
        countryInfoContainer.setCurrency(result.get("curency"));
        countryInfoContainer.setCurrencyCode(result.get("curencycode"));
        return countryInfoContainer;
    }
}
