
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.operationhistory.data.AuthorizationHeader;
import org.russianpost.rtm.dataexchangeespp.data.PostalOrderEventsForMailInput;


/**
 * <p>Java class for PostalOrderEventsForMail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalOrderEventsForMail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}AuthorizationHeader" minOccurs="0"/>
 *         &lt;element ref="{http://www.russianpost.org/RTM/DataExchangeESPP/Data}PostalOrderEventsForMailInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalOrderEventsForMail", propOrder = {
    "authorizationHeader",
    "postalOrderEventsForMailInput"
})
public class PostalOrderEventsForMail {

    @XmlElement(name = "AuthorizationHeader", namespace = "http://russianpost.org/operationhistory/data")
    protected AuthorizationHeader authorizationHeader;
    @XmlElement(name = "PostalOrderEventsForMailInput", namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data")
    protected PostalOrderEventsForMailInput postalOrderEventsForMailInput;

    /**
     * Gets the value of the authorizationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationHeader }
     *     
     */
    public AuthorizationHeader getAuthorizationHeader() {
        return authorizationHeader;
    }

    /**
     * Sets the value of the authorizationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationHeader }
     *     
     */
    public void setAuthorizationHeader(AuthorizationHeader value) {
        this.authorizationHeader = value;
    }

    /**
     * Gets the value of the postalOrderEventsForMailInput property.
     * 
     * @return
     *     possible object is
     *     {@link PostalOrderEventsForMailInput }
     *     
     */
    public PostalOrderEventsForMailInput getPostalOrderEventsForMailInput() {
        return postalOrderEventsForMailInput;
    }

    /**
     * Sets the value of the postalOrderEventsForMailInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalOrderEventsForMailInput }
     *     
     */
    public void setPostalOrderEventsForMailInput(PostalOrderEventsForMailInput value) {
        this.postalOrderEventsForMailInput = value;
    }

}
