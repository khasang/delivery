package net.webservicex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CountryClient {

    public CountryClient() {
    }

    public String getCountryByCode(String code) {
        Country countryService = new Country();
        CountrySoap country = countryService.getCountrySoap();
        String preResult = country.getCountryByCountryCode(code);
        return parseCountry(preResult);
    }

    private String parseCountry(String preResult) {
        Document document;
        document = Jsoup.parse(preResult);
        Elements codes = document.select("countrycode");
        Elements names = document.select("name");
        return "Code: " + codes.get(0).text() + "<br/>" + "Name: " + names.get(0).text();
    }
}
