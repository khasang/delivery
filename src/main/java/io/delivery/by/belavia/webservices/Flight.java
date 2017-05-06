
package io.delivery.by.belavia.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Flight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Airport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ScheduleTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="ExpectedTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="ActualTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Aircraft" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flight")
public class Flight {

    @XmlAttribute(name = "FlightNumber")
    protected String flightNumber;
    @XmlAttribute(name = "Airport")
    protected String airport;
    @XmlAttribute(name = "ScheduleTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scheduleTime;
    @XmlAttribute(name = "ExpectedTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expectedTime;
    @XmlAttribute(name = "ActualTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualTime;
    @XmlAttribute(name = "Status")
    protected String status;
    @XmlAttribute(name = "Aircraft")
    protected String aircraft;

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Gets the value of the airport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets the value of the airport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirport(String value) {
        this.airport = value;
    }

    /**
     * Gets the value of the scheduleTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Sets the value of the scheduleTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setScheduleTime(XMLGregorianCalendar value) {
        this.scheduleTime = value;
    }

    /**
     * Gets the value of the expectedTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpectedTime() {
        return expectedTime;
    }

    /**
     * Sets the value of the expectedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpectedTime(XMLGregorianCalendar value) {
        this.expectedTime = value;
    }

    /**
     * Gets the value of the actualTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualTime() {
        return actualTime;
    }

    /**
     * Sets the value of the actualTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualTime(XMLGregorianCalendar value) {
        this.actualTime = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the aircraft property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAircraft() {
        return aircraft;
    }

    /**
     * Sets the value of the aircraft property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAircraft(String value) {
        this.aircraft = value;
    }

}
