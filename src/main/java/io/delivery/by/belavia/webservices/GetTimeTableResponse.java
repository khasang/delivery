
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
 *         &lt;element name="GetTimeTableResult" type="{http://webservices.belavia.by/}TimeTableResponce" minOccurs="0"/>
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
    "getTimeTableResult"
})
@XmlRootElement(name = "GetTimeTableResponse")
public class GetTimeTableResponse {

    @XmlElement(name = "GetTimeTableResult")
    protected TimeTableResponce getTimeTableResult;

    /**
     * Gets the value of the getTimeTableResult property.
     * 
     * @return
     *     possible object is
     *     {@link TimeTableResponce }
     *     
     */
    public TimeTableResponce getGetTimeTableResult() {
        return getTimeTableResult;
    }

    /**
     * Sets the value of the getTimeTableResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeTableResponce }
     *     
     */
    public void setGetTimeTableResult(TimeTableResponce value) {
        this.getTimeTableResult = value;
    }

}
