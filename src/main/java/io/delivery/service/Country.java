package io.delivery.service;

import net.webservicex.*;

public class Country {

    //private CurrencyConvertorSoap convertor = new CurrencyConvertor().getCurrencyConvertorSoap();
    private CountrySoap countryDetails = new net.webservicex.Country().getCountrySoap();

    public Country() {
    }

    public String currencyInfo(String country) {
      return countryDetails.getCurrencyByCountry(country);
    }

//    public String currencyRate(String from, String to) {
//        Double currencyRate = convertor.conversionRate(Currency.RUB,Currency.USD);
//        return currencyRate.toString();
//    }

    public String getCurrencyName(String result) {
        if (result.contains("Table")) {
            return result.substring(result.indexOf("<Currency>")+10,result.indexOf("</Currency>"));
        }
        return "unknown";
    }

    public String getCurrencyCode(String result) {
        return result.substring(result.indexOf("<CurrencyCode>")+14,result.indexOf("</CurrencyCode>"));
    }
}