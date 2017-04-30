
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.custom_duty_info.data.CustomDutyEventsForMailOutput;


/**
 * <p>Java class for getCustomDutyEventsForMailResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCustomDutyEventsForMailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.russianpost.org/custom-duty-info/data}CustomDutyEventsForMailOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomDutyEventsForMailResponse", propOrder = {
    "customDutyEventsForMailOutput"
})
public class GetCustomDutyEventsForMailResponse {

    @XmlElement(name = "CustomDutyEventsForMailOutput", namespace = "http://www.russianpost.org/custom-duty-info/data")
    protected CustomDutyEventsForMailOutput customDutyEventsForMailOutput;

    /**
     * Gets the value of the customDutyEventsForMailOutput property.
     * 
     * @return
     *     possible object is
     *     {@link CustomDutyEventsForMailOutput }
     *     
     */
    public CustomDutyEventsForMailOutput getCustomDutyEventsForMailOutput() {
        return customDutyEventsForMailOutput;
    }

    /**
     * Sets the value of the customDutyEventsForMailOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomDutyEventsForMailOutput }
     *     
     */
    public void setCustomDutyEventsForMailOutput(CustomDutyEventsForMailOutput value) {
        this.customDutyEventsForMailOutput = value;
    }

}
