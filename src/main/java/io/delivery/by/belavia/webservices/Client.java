package io.delivery.by.belavia.webservices;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Client {
    private static final String ADDRESS = "http://86.57.245.235/TimeTable/Service.asmx?WSDL";

    public Client() {
    }

    public String getListOfAirports(String language) throws SOAPException, IOException{
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://webservices.belavia.by/", "OnlineTimeTable");

        Service service = Service.create(url, qName);

        OnlineTimeTableSoap hello = service.getPort(OnlineTimeTableSoap.class);

        AirportsResponse response = hello.getAirportsList(language);
        List<Airport> airportList = response.getAirport();
        List<String> airportIataAndName = new ArrayList<>();
        for(Airport a : airportList){
            airportIataAndName.add("| " + a.getIATA() + " - " + a.getName() + " |");
        }
        return airportIataAndName.toString();
    }

    public String getListOfFlights(String airport, String timeTableType, String date) throws SOAPException, IOException{
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://webservices.belavia.by/", "OnlineTimeTable");

        Service service = Service.create(url, qName);

        OnlineTimeTableSoap hello = service.getPort(OnlineTimeTableSoap.class);

        String poingOfDeparture;

        TimeTableType type;
        if(timeTableType.equals("Arrival")) {
            type = TimeTableType.ARRIVAL;
            poingOfDeparture = " fling to ";
        }
        else if(timeTableType.equals("Departure")) {
            type = TimeTableType.DEPARTURE;
            poingOfDeparture = " fling from ";
        }
        else throw new IllegalArgumentException("Type must be Arrival or Departure");

        XMLGregorianCalendar calendar = new XMLGregorianCalendarImpl();
        String[] splittedDate = date.split("-");
        if(!splittedDate[0].equals("2017"))
            throw new IllegalArgumentException("Year must be 2017");
        if(!splittedDate[1].equals("04"))
            throw new IllegalArgumentException("Month must be 04");

        int year = Integer.parseInt(splittedDate[0]);
        int month = Integer.parseInt(splittedDate[1]);
        int day = Integer.parseInt(splittedDate[2]);

        calendar.setDay(day);
        calendar.setMonth(month);
        calendar.setYear(year);

        TimeTableResponce response = hello.getTimeTable(airport, type, calendar);
        ArrayOfFlight flights = response.getFlights();
        List<Flight> listOfFlights = flights.getFlight();
        List<String> stringListOfFlights = new ArrayList<>();
        for(Flight f : listOfFlights){
            stringListOfFlights.add("| Aircraft " + f.getAircraft() + " flight number: " +
                                    f.getFlightNumber() +
                                    poingOfDeparture + " airport IATA: " +
                                    f.getAirport() + " is " +
                                    f.getStatus() + " |");
        }

        if (stringListOfFlights.size() > 0)
            return stringListOfFlights.toString();
        else
            return "There is no flights " +
                    poingOfDeparture +
                    airport + " " +
                    calendar.getDay() + "." +
                    calendar.getMonth() + "." +
                    calendar.getYear();
    }
}
