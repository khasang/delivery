package net.webservicex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class CountryClient {

    public CountryClient() {
    }

    public Map<String, String> getCountryByCode(String code) {
        Country countryService = new Country();
        CountrySoap country = countryService.getCountrySoap();
        String response = country.getCountryByCountryCode(code);
        return parseCountry(response);
    }

    private Map<String, String> parseCountry(String response) {
        Document document;
        document = Jsoup.parse(response);
        Elements codes = document.select("countrycode");
        Elements names = document.select("name");

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("code", codes.get(0).text());
        resultMap.put("name", names.get(0).text());

        return resultMap;
    }
}