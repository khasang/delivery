
package io.delivery.by.belavia.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAirportsListResult" type="{http://webservices.belavia.by/}AirportsResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getAirportsListResult"
})
@XmlRootElement(name = "GetAirportsListResponse")
public class GetAirportsListResponse {

    @XmlElement(name = "GetAirportsListResult")
    protected AirportsResponse getAirportsListResult;

    /**
     * Gets the value of the getAirportsListResult property.
     * 
     * @return
     *     possible object is
     *     {@link AirportsResponse }
     *     
     */
    public AirportsResponse getGetAirportsListResult() {
        return getAirportsListResult;
    }

    /**
     * Sets the value of the getAirportsListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirportsResponse }
     *     
     */
    public void setGetAirportsListResult(AirportsResponse value) {
        this.getAirportsListResult = value;
    }

}
