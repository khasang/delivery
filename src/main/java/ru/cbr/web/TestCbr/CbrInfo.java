package ru.cbr.web.TestCbr;

import ru.cbr.web.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

public class CbrInfo {
    public static void main(String[] args) {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        XMLGregorianCalendar onDate = null;
        try {
            onDate = GetCursOnDateResultParser.getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
        GetCursOnDateResponse.GetCursOnDateResult curs = port.getCursOnDate(onDate);

        onDate =port.getLatestDateTime();
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        GetCursOnDateResultParser.Valute list = null;

        try{
            list = GetCursOnDateResultParser.getValuteByValuteCh("EUR", result);
        } catch (Exception e){

        }
        System.out.println(list.curs);

        try{
            list = GetCursOnDateResultParser.getValuteByValuteCode("840", result);
        } catch (Exception e){

        }
        System.out.println(list.curs);
    }
}
