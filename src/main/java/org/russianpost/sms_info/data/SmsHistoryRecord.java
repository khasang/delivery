
package org.russianpost.sms_info.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SmsHistoryRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SmsHistoryRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NotificationTypeID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="NotificationTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NotificationStatusID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="NotificationStatusName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NotificationStatusDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SendedID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SourceOperation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmsHistoryRecord", propOrder = {
    "id",
    "number",
    "notificationTypeID",
    "notificationTypeName",
    "notificationStatusID",
    "notificationStatusName",
    "notificationStatusDate",
    "sendedID",
    "sourceOperation"
})
public class SmsHistoryRecord {

    @XmlElement(name = "Id", required = true)
    protected BigInteger id;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "NotificationTypeID", required = true)
    protected BigInteger notificationTypeID;
    @XmlElement(name = "NotificationTypeName", required = true)
    protected String notificationTypeName;
    @XmlElement(name = "NotificationStatusID", required = true)
    protected BigInteger notificationStatusID;
    @XmlElement(name = "NotificationStatusName", required = true)
    protected String notificationStatusName;
    @XmlElement(name = "NotificationStatusDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar notificationStatusDate;
    @XmlElement(name = "SendedID", required = true)
    protected BigInteger sendedID;
    @XmlElement(name = "SourceOperation", required = true)
    protected String sourceOperation;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

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
     * Gets the value of the notificationTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNotificationTypeID() {
        return notificationTypeID;
    }

    /**
     * Sets the value of the notificationTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNotificationTypeID(BigInteger value) {
        this.notificationTypeID = value;
    }

    /**
     * Gets the value of the notificationTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationTypeName() {
        return notificationTypeName;
    }

    /**
     * Sets the value of the notificationTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationTypeName(String value) {
        this.notificationTypeName = value;
    }

    /**
     * Gets the value of the notificationStatusID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNotificationStatusID() {
        return notificationStatusID;
    }

    /**
     * Sets the value of the notificationStatusID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNotificationStatusID(BigInteger value) {
        this.notificationStatusID = value;
    }

    /**
     * Gets the value of the notificationStatusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationStatusName() {
        return notificationStatusName;
    }

    /**
     * Sets the value of the notificationStatusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationStatusName(String value) {
        this.notificationStatusName = value;
    }

    /**
     * Gets the value of the notificationStatusDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNotificationStatusDate() {
        return notificationStatusDate;
    }

    /**
     * Sets the value of the notificationStatusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNotificationStatusDate(XMLGregorianCalendar value) {
        this.notificationStatusDate = value;
    }

    /**
     * Gets the value of the sendedID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSendedID() {
        return sendedID;
    }

    /**
     * Sets the value of the sendedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSendedID(BigInteger value) {
        this.sendedID = value;
    }

    /**
     * Gets the value of the sourceOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOperation() {
        return sourceOperation;
    }

    /**
     * Sets the value of the sourceOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOperation(String value) {
        this.sourceOperation = value;
    }

}
