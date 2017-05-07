
package io.delivery.by.belavia.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeTableResponce complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeTableResponce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Flights" type="{http://webservices.belavia.by/}ArrayOfFlight" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeTableResponce", propOrder = {
    "flights"
})
public class TimeTableResponce {

    @XmlElement(name = "Flights")
    protected ArrayOfFlight flights;

    /**
     * Gets the value of the flights property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFlight }
     *     
     */
    public ArrayOfFlight getFlights() {
        return flights;
    }

    /**
     * Sets the value of the flights property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFlight }
     *     
     */
    public void setFlights(ArrayOfFlight value) {
        this.flights = value;
    }

}
