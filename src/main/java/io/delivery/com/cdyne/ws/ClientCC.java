package io.delivery.com.cdyne.ws;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClientCC {
    private static final String ADDRESS = "https://ws.cdyne.com/creditcardverify/luhnchecker.asmx?wsdl";

    public ClientCC() {
    }

    public List<String> result() throws MalformedURLException {
        URL url = new URL(ADDRESS);

        QName qName = new QName("https://ws.cdyne.com/creditcardverify/luhnchecker.asmx?wsdl", "LuhnChecker");

        Service service = Service.create(url, qName);

//        https.www_w3schools_com.xml.TempConvertSoap hello = service.getPort(https.www_w3schools_com.xml.TempConvertSoap.class);

        LuhnCheckerSoap hello = service.getPort(LuhnCheckerSoap.class);

        CheckCC check = new CheckCC();
        check.setCardNumber("12345");

        List<String> list = new ArrayList<>();
        list.addAll(hello.returnIndicator(check).getCardType().isCardValid().toString());
//        list.addAll(hello.returnIndicator().getCardType().isCardValid().toString());
        return list;


    }
}

