package net.yandex.speller.services.spellservice;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String ADDRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    public Client() {
    }

    public List<String> result(String check) throws SOAPException, IOException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

        Service service = Service.create(url, qName);

        SpellServiceSoap hello = service.getPort(SpellServiceSoap.class);

        CheckTextRequest checkTextRequest = new CheckTextRequest();
        checkTextRequest.setText(check);
        checkTextRequest.setLang("en");
        checkTextRequest.setFormat("plain");

        List<String> list = new ArrayList<>();
        list.addAll(hello
                .checkText(checkTextRequest)
                .getSpellResult()
                .getError().get(0).getS());
        return list;
    }
}
