package net.webservicex;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

public class CurrencyClient {
    private final String ADDRESS = "http://www.webservicex.net/CurrencyConvertor.asmx?WSDL";
    @Autowired
    ConversionRate conversionRate;

    public CurrencyClient() {
    }

    public double result() throws SOAPException, IOException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://www.webserviceX.NET/", "CurrencyConvertor");
        Service service = Service.create(url, qName);

        CurrencyConvertorSoap convertorSoap = service.getPort(CurrencyConvertorSoap.class);
        conversionRate.setFromCurrency(Currency.EUR);
        conversionRate.setToCurrency(Currency.RUB);

        return convertorSoap.conversionRate(conversionRate.getFromCurrency(), conversionRate.getToCurrency());
    }
}
