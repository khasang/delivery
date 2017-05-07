
package io.delivery.by.belavia.webservices;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.belavia.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.belavia.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTimeTableResponse }
     * 
     */
    public GetTimeTableResponse createGetTimeTableResponse() {
        return new GetTimeTableResponse();
    }

    /**
     * Create an instance of {@link TimeTableResponce }
     * 
     */
    public TimeTableResponce createTimeTableResponce() {
        return new TimeTableResponce();
    }

    /**
     * Create an instance of {@link GetAirportsList }
     * 
     */
    public GetAirportsList createGetAirportsList() {
        return new GetAirportsList();
    }

    /**
     * Create an instance of {@link GetAirportsListResponse }
     * 
     */
    public GetAirportsListResponse createGetAirportsListResponse() {
        return new GetAirportsListResponse();
    }

    /**
     * Create an instance of {@link AirportsResponse }
     * 
     */
    public AirportsResponse createAirportsResponse() {
        return new AirportsResponse();
    }

    /**
     * Create an instance of {@link GetTimeTable }
     * 
     */
    public GetTimeTable createGetTimeTable() {
        return new GetTimeTable();
    }

    /**
     * Create an instance of {@link ArrayOfFlight }
     * 
     */
    public ArrayOfFlight createArrayOfFlight() {
        return new ArrayOfFlight();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link Airport }
     * 
     */
    public Airport createAirport() {
        return new Airport();
    }

}
