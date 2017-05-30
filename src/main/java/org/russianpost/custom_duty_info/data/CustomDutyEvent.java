
package org.russianpost.custom_duty_info.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CustomDutyEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomDutyEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="Number" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EventDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="EventType" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="EventName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IndexTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IndexEvent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CountryEventCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CountryToCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SumPaymentForward" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomDutyEvent")
public class CustomDutyEvent {

    @XmlAttribute(name = "Number", required = true)
    protected String number;
    @XmlAttribute(name = "EventDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventDateTime;
    @XmlAttribute(name = "EventType", required = true)
    protected BigInteger eventType;
    @XmlAttribute(name = "EventName")
    protected String eventName;
    @XmlAttribute(name = "IndexTo")
    protected String indexTo;
    @XmlAttribute(name = "IndexEvent")
    protected String indexEvent;
    @XmlAttribute(name = "CountryEventCode")
    protected String countryEventCode;
    @XmlAttribute(name = "CountryToCode")
    protected String countryToCode;
    @XmlAttribute(name = "SumPaymentForward", required = true)
    protected BigInteger sumPaymentForward;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the eventDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventDateTime() {
        return eventDateTime;
    }

    /**
     * Sets the value of the eventDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventDateTime(XMLGregorianCalendar value) {
        this.eventDateTime = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEventType(BigInteger value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the eventName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the indexTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexTo() {
        return indexTo;
    }

    /**
     * Sets the value of the indexTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexTo(String value) {
        this.indexTo = value;
    }

    /**
     * Gets the value of the indexEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexEvent() {
        return indexEvent;
    }

    /**
     * Sets the value of the indexEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexEvent(String value) {
        this.indexEvent = value;
    }

    /**
     * Gets the value of the countryEventCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryEventCode() {
        return countryEventCode;
    }

    /**
     * Sets the value of the countryEventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryEventCode(String value) {
        this.countryEventCode = value;
    }

    /**
     * Gets the value of the countryToCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryToCode() {
        return countryToCode;
    }

    /**
     * Sets the value of the countryToCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryToCode(String value) {
        this.countryToCode = value;
    }

    /**
     * Gets the value of the sumPaymentForward property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSumPaymentForward() {
        return sumPaymentForward;
    }

    /**
     * Sets the value of the sumPaymentForward property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSumPaymentForward(BigInteger value) {
        this.sumPaymentForward = value;
    }

}
