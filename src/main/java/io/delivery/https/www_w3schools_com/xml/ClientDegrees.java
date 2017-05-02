package io.delivery.https.www_w3schools_com.xml;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClientDegrees {
    private static final String ADDRESS = "https://www.w3schools.com/xml/tempconvert.asmx?WSDL";

    public ClientDegrees() {
    }

    public List<String> result(String celsius) throws MalformedURLException {
        URL url = new URL(ADDRESS);

        QName qName = new QName("https://www.w3schools.com/xml/tempconvert.asmx?WSDL", "TempConvert");

        Service service = Service.create(url, qName);

        TempConvertSoap hello = service.getPort(TempConvertSoap.class);

        CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheit();
        celsiusToFahrenheit.setCelsius(celsius);

        List<String> list = new ArrayList<>();
        list.add(hello
                .celsiusToFahrenheit(celsius)
                        .toString()
                );
        return list;
    }
}

