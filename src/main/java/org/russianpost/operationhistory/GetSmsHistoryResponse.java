
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.sms_info.data.SmsHistoryData;


/**
 * <p>Java class for getSmsHistoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSmsHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/sms-info/data}SmsHistoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSmsHistoryResponse", propOrder = {
    "smsHistoryData"
})
public class GetSmsHistoryResponse {

    @XmlElement(name = "SmsHistoryData", namespace = "http://russianpost.org/sms-info/data")
    protected SmsHistoryData smsHistoryData;

    /**
     * Gets the value of the smsHistoryData property.
     * 
     * @return
     *     possible object is
     *     {@link SmsHistoryData }
     *     
     */
    public SmsHistoryData getSmsHistoryData() {
        return smsHistoryData;
    }

    /**
     * Sets the value of the smsHistoryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmsHistoryData }
     *     
     */
    public void setSmsHistoryData(SmsHistoryData value) {
        this.smsHistoryData = value;
    }

}
