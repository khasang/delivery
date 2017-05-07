
package org.russianpost.operationhistory.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DestinationAddress" type="{http://russianpost.org/operationhistory/data}Address" minOccurs="0"/>
 *         &lt;element name="OperationAddress" type="{http://russianpost.org/operationhistory/data}Address"/>
 *         &lt;element name="MailDirect" type="{http://russianpost.org/operationhistory/data}Country" minOccurs="0"/>
 *         &lt;element name="CountryFrom" type="{http://russianpost.org/operationhistory/data}Country" minOccurs="0"/>
 *         &lt;element name="CountryOper" type="{http://russianpost.org/operationhistory/data}Country"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressParameters", propOrder = {
    "destinationAddress",
    "operationAddress",
    "mailDirect",
    "countryFrom",
    "countryOper"
})
public class AddressParameters {

    @XmlElement(name = "DestinationAddress")
    protected Address destinationAddress;
    @XmlElement(name = "OperationAddress", required = true)
    protected Address operationAddress;
    @XmlElement(name = "MailDirect")
    protected Country mailDirect;
    @XmlElement(name = "CountryFrom")
    protected Country countryFrom;
    @XmlElement(name = "CountryOper", required = true)
    protected Country countryOper;

    /**
     * Gets the value of the destinationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Sets the value of the destinationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDestinationAddress(Address value) {
        this.destinationAddress = value;
    }

    /**
     * Gets the value of the operationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getOperationAddress() {
        return operationAddress;
    }

    /**
     * Sets the value of the operationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setOperationAddress(Address value) {
        this.operationAddress = value;
    }

    /**
     * Gets the value of the mailDirect property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getMailDirect() {
        return mailDirect;
    }

    /**
     * Sets the value of the mailDirect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setMailDirect(Country value) {
        this.mailDirect = value;
    }

    /**
     * Gets the value of the countryFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountryFrom() {
        return countryFrom;
    }

    /**
     * Sets the value of the countryFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountryFrom(Country value) {
        this.countryFrom = value;
    }

    /**
     * Gets the value of the countryOper property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountryOper() {
        return countryOper;
    }

    /**
     * Sets the value of the countryOper property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountryOper(Country value) {
        this.countryOper = value;
    }

}
