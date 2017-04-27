package io.delivery.by.belavia.webservices;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String ADDRESS = "http://86.57.245.235/TimeTable/Service.asmx?WSDL";
    private String pointOfDeparture;

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

        OnlineTimeTableSoap timeTableSoap = service.getPort(OnlineTimeTableSoap.class);

        TimeTableType type = setTimeTabelType(timeTableType);

        XMLGregorianCalendar validatedDate = validateAndSetDate(date);

        TimeTableResponce response = timeTableSoap.getTimeTable(airport, type, validatedDate);

        ArrayOfFlight flights = response.getFlights();
        List<String> responseList = getListOfFlightsResponse(flights.getFlight());

        if (responseList.size() > 0)
            return responseList.toString();
        else
            return "There is no flights " +
                    pointOfDeparture +
                    airport + " " +
                    validatedDate.toString();
    }

    private XMLGregorianCalendar validateAndSetDate(String date) throws IllegalArgumentException{
        XMLGregorianCalendar validatedDate = new XMLGregorianCalendarImpl();

        LocalDate localDate = LocalDate.now();
        int currentYear = localDate.getYear();
        int currentMonth = localDate.getMonthValue();
        int currentDay = localDate.getDayOfMonth();

        String[] splittedDate = date.split("[\\p{Punct}]");
        int askedYear = Integer.parseInt(splittedDate[0]);
        int askedMonth = Integer.parseInt(splittedDate[1]);
        int askedDay = Integer.parseInt(splittedDate[2]);

        if(currentYear != askedYear)
            throw new IllegalArgumentException("The year incorrect (must be current year)");
        else if(currentMonth != askedMonth)
            throw new IllegalArgumentException("The month incorrect (must be current month)");
        else if(Math.abs(currentDay - askedDay) > 2){
            throw new IllegalArgumentException("The day must be between +-2 days of current date");
        }
        else{
            validatedDate.setYear(askedYear);
            validatedDate.setMonth(askedMonth);
            validatedDate.setDay(askedDay);
        }

        return validatedDate;
    }

    private TimeTableType setTimeTabelType(String timeTableType) throws IllegalArgumentException{
        TimeTableType type;
        if(timeTableType.equals("Arrival")) {
            type = TimeTableType.ARRIVAL;
            pointOfDeparture = " fling to ";
        }
        else if(timeTableType.equals("Departure")) {
            type = TimeTableType.DEPARTURE;
            pointOfDeparture = " fling from ";
        }
        else throw new IllegalArgumentException("Type must be Arrival or Departure");

        return type;
    }

    private List<String> getListOfFlightsResponse(List<Flight> listOfFlights){
        List<String> stringListOfFlights = new ArrayList<>();
        for(Flight f : listOfFlights){
            stringListOfFlights.add("| Aircraft "       + f.getAircraft() +
                    " flight number: "  + f.getFlightNumber() +
                    pointOfDeparture    + // "from" or "to"
                    " airport IATA: "   + f.getAirport() +
                    " is "              + f.getStatus() +
                    " actual time: "    + f.getActualTime() +
                    " expected time: "  + f.getExpectedTime() +
                    " scheduled time: " + f.getScheduleTime() + " |");
        }
        return stringListOfFlights;
    }
}
