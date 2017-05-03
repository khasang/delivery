
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.custom_duty_info.data.CustomDutyEventsForMailInput;
import org.russianpost.operationhistory.data.AuthorizationHeader;


/**
 * <p>Java class for getCustomDutyEventsForMail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCustomDutyEventsForMail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}AuthorizationHeader" minOccurs="0"/>
 *         &lt;element ref="{http://www.russianpost.org/custom-duty-info/data}CustomDutyEventsForMailInput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomDutyEventsForMail", propOrder = {
    "authorizationHeader",
    "customDutyEventsForMailInput"
})
public class GetCustomDutyEventsForMail {

    @XmlElement(name = "AuthorizationHeader", namespace = "http://russianpost.org/operationhistory/data")
    protected AuthorizationHeader authorizationHeader;
    @XmlElement(name = "CustomDutyEventsForMailInput", namespace = "http://www.russianpost.org/custom-duty-info/data")
    protected CustomDutyEventsForMailInput customDutyEventsForMailInput;

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
     * Gets the value of the customDutyEventsForMailInput property.
     * 
     * @return
     *     possible object is
     *     {@link CustomDutyEventsForMailInput }
     *     
     */
    public CustomDutyEventsForMailInput getCustomDutyEventsForMailInput() {
        return customDutyEventsForMailInput;
    }

    /**
     * Sets the value of the customDutyEventsForMailInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomDutyEventsForMailInput }
     *     
     */
    public void setCustomDutyEventsForMailInput(CustomDutyEventsForMailInput value) {
        this.customDutyEventsForMailInput = value;
    }

}
