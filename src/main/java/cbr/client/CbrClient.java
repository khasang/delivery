package cbr.client;

import net.webservisex.LatLonDate;
import net.webservisex.SunSetRiseService;
import net.webservisex.SunSetRiseServiceSoap;

import javax.xml.soap.SOAPException;
import java.io.IOException;

public class CbrClient {
    public CbrClient() {
    }

    public LatLonDate enumValutes() throws SOAPException, IOException {
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


}
