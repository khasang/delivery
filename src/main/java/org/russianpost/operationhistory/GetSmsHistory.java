
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.operationhistory.data.AuthorizationHeader;
import org.russianpost.sms_info.data.SmsHistoryRequest;


/**
 * <p>Java class for getSmsHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSmsHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}AuthorizationHeader" minOccurs="0"/>
 *         &lt;element ref="{http://russianpost.org/sms-info/data}SmsHistoryRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSmsHistory", propOrder = {
    "authorizationHeader",
    "smsHistoryRequest"
})
public class GetSmsHistory {

    @XmlElement(name = "AuthorizationHeader", namespace = "http://russianpost.org/operationhistory/data")
    protected AuthorizationHeader authorizationHeader;
    @XmlElement(name = "SmsHistoryRequest", namespace = "http://russianpost.org/sms-info/data")
    protected SmsHistoryRequest smsHistoryRequest;

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
     * Gets the value of the smsHistoryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SmsHistoryRequest }
     *     
     */
    public SmsHistoryRequest getSmsHistoryRequest() {
        return smsHistoryRequest;
    }

    /**
     * Sets the value of the smsHistoryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmsHistoryRequest }
     *     
     */
    public void setSmsHistoryRequest(SmsHistoryRequest value) {
        this.smsHistoryRequest = value;
    }

}
