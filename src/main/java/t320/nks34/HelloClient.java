package t320.nks34;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

public class HelloClient {
    private static final String ADDRESS = "http://t320webservices.open.ac.uk/t320/services/HelloService?wsdl";

    public HelloClient() {
    }

    public String result(String check) throws SOAPException, IOException{
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://nks34.t320", "HelloService");
        Service service = Service.create(url, qName);
        HelloServicePortType hello = service.getPort(HelloServicePortType.class);
        HelloName helloName = new HelloName();
        helloName.setName(new JAXBElement<>(qName, String.class, check));
        return helloName.getName().toString();
    }
}
