package io.delivery.wsclient;

import cbr.client.DailyInfo;
import cbr.client.DailyInfoSoap;
import cbr.client.GetCursDynamicXMLResponse;
import net.webservisex.LatLonDate;
import net.webservisex.SunSetRiseService;
import net.webservisex.SunSetRiseServiceSoap;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class WSClient {
    public WSClient() {
    }

    public class MyProxySelector extends ProxySelector {

        @Override
        public List<Proxy> select(URI uri) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 2000));
            ArrayList list = new ArrayList();
            list.add(proxy);
            return list;
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            System.err.println("Connection to " + uri + " failed.");
        }

    }

    public LatLonDate getSunSetRiseTime() throws SOAPException, IOException {
        ProxySelector.setDefault(new MyProxySelector());

        SunSetRiseService sunSetRiseService = new SunSetRiseService();
        SunSetRiseServiceSoap service = sunSetRiseService.getSunSetRiseServiceSoap();

        LatLonDate latLonDate = new LatLonDate();
        latLonDate.setDay(2);
        latLonDate.setMonth(5);
        latLonDate.setYear(2017);
        latLonDate.setLatitude(-59.95f);
        latLonDate.setLongitude(30.31f);
        latLonDate.setTimeZone(3);
        LatLonDate res = service.getSunSetRiseTime(latLonDate);
        return res;
    }

    public List<Object> getCursDynamicXML() throws SOAPException, IOException, DatatypeConfigurationException {
//        ProxySelector.setDefault(new MyProxySelector());

        DailyInfoSoap service = (new DailyInfo()).getDailyInfoSoap();

        XMLGregorianCalendar endOfPeriod = service.getLatestDateTime();
        XMLGregorianCalendar beginOfPeriod = (XMLGregorianCalendar) endOfPeriod.clone();
        beginOfPeriod.add(DatatypeFactory.newInstance().newDuration(false, 0, 0, 1, 0, 0, 0));
        GetCursDynamicXMLResponse.GetCursDynamicXMLResult res = service.getCursDynamicXML(
                beginOfPeriod,
                endOfPeriod,
                "R01235");
        return res.getContent();
    }
}
