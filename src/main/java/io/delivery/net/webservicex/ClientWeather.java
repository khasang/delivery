package io.delivery.net.webservicex;

import io.delivery.https.www_w3schools_com.xml.CelsiusToFahrenheit;
import io.delivery.https.www_w3schools_com.xml.TempConvertSoap;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ClientWeather {
    private static final String ADDRESS = "http://www.webservicex.net/globalweather.asmx?WSDL";

    public ClientWeather() {
    }

    // метод получение городов по стране
    public String citiesByCountry(String countryName) throws MalformedURLException {
        URL url = new URL(ADDRESS);

        QName qName = new QName("http://www.webservicex.net/globalweather.asmx?WSDL", "GlobalWeather");

        Service service = Service.create(url, qName);

        GlobalWeatherSoap hello = service.getPort(GlobalWeatherSoap.class);

        String resultCitiesByCountry = hello.getCitiesByCountry(countryName);

//        List<String> list = new ArrayList<>();
//        list.add(hello.
//        );
        return resultCitiesByCountry;
    }

    // метод получение погоды по стране и городу
    public String weather(String cityName, String countryName) throws MalformedURLException {
        URL url = new URL(ADDRESS);

        QName qName = new QName("http://www.webservicex.net/globalweather.asmx?WSDL", "GlobalWeather");

        Service service = Service.create(url, qName);

        GlobalWeatherSoap hello = service.getPort(GlobalWeatherSoap.class);

        String resultWeather = hello.getWeather(cityName, countryName);

        return resultWeather;
    }
}
