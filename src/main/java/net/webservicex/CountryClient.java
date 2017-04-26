package net.webservicex;

public class CountryClient {

    public CountryClient() {
    }

    public String getCountryByCode(String code) {
        Country countryService = new Country();
        CountrySoap country = countryService.getCountrySoap();
        String result = country.getCountryByCountryCode(code);
        return result;
    }
}
