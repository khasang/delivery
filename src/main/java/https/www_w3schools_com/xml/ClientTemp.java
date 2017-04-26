package https.www_w3schools_com.xml;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

public class ClientTemp {
    private static final String ADDRESS = "https://www.w3schools.com/xml/tempconvert.asmx?WSDL";

    public ClientTemp() {
    }

    public String result(String convert) throws SOAPException, IOException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("https://www.w3schools.com/xml/", "TempConvert");
        Service service = Service.create(url, qName);
        TempConvertSoap hello = service.getPort(TempConvertSoap.class);
        return hello.celsiusToFahrenheit(convert);
    }
}
