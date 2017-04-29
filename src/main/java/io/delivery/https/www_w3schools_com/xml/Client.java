package io.delivery.https.www_w3schools_com.xml;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    private static final String ADDRESS = "https://www.w3schools.com/xml/tempconvert.asmx?WSDL";

    public Client() {
    }

    public String result() throws MalformedURLException {
        URL url = new URL(ADDRESS);

        QName qName = new QName("https://www.w3schools.com/xml/tempconvert.asmx?WSDL", "TempConvert");

        Service service = Service.create(url, qName);

//        kirillSoap.https.www_w3schools_com.xml.TempConvertSoap hello = service.getPort(kirillSoap.https.www_w3schools_com.xml.TempConvertSoap.class);

        TempConvertSoap hello = service.getPort(TempConvertSoap.class);

        CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheit();
        celsiusToFahrenheit


    }
}
