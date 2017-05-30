
package org.russianpost.custom_duty_info.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomDutyEventsForMailFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomDutyEventsForMailFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ErrorID" type="{http://www.russianpost.org/custom-duty-info/data}CustomDutyEventsForMailErrors" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomDutyEventsForMailFault")
public class CustomDutyEventsForMailFault {

    @XmlAttribute(name = "ErrorID")
    protected CustomDutyEventsForMailErrors errorID;

    /**
     * Gets the value of the errorID property.
     * 
     * @return
     *     possible object is
     *     {@link CustomDutyEventsForMailErrors }
     *     
     */
    public CustomDutyEventsForMailErrors getErrorID() {
        return errorID;
    }

    /**
     * Sets the value of the errorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomDutyEventsForMailErrors }
     *     
     */
    public void setErrorID(CustomDutyEventsForMailErrors value) {
        this.errorID = value;
    }

}
