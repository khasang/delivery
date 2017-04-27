package io.delivery.service;

import net.webservicex.Country;
import net.webservicex.CountrySoap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class CountryClient {

    private CountrySoap countrySoap = new Country().getCountrySoap();

    public CountryClient() {
    }

    public Map<String, String> getCountryByCountryCode(String code) {
        String response = countrySoap.getCountryByCountryCode(code);
        return parseCountry(response);
    }

    public Map<String, String> getCurrencyByCountry(String country) {
        String response = countrySoap.getCurrencyByCountry(country);
        return parseCountry(response);
    }

    public Map<String, String> getCountryByCurrency(String currency) {
        String response = countrySoap.getCurrencyCodeByCurrencyName(currency);
        return parseCountry(response);
    }

    public Map<String, String> getCountryByCurrencyCode(String currencycode) {
        String response = countrySoap.getCountryByCurrencyCode(currencycode);
        return parseCountry(response);
    }

    private Map<String, String> parseCountry(String response) {
        Document document;
        document = Jsoup.parse(response);
        Elements code = document.select("countrycode");
        Elements name = document.select("name");
        Elements currency = document.select("currency");
        Elements currencyCode = document.select("currencycode");

        Map<String, String> resultMap = new HashMap<>();
        if (code.size() != 0) resultMap.put("code", code.get(0).text());
        if (name.size() != 0) resultMap.put("name", name.get(0).text());
        if (currency.size() != 0) resultMap.put("curency", currency.get(0).text());
        if (currencyCode.size() != 0) resultMap.put("curencycode", currencyCode.get(0).text());

        return resultMap;
    }
}