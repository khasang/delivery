
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.rtm.dataexchangeespp.data.PostalOrderEventsForMaiOutput;


/**
 * <p>Java class for PostalOrderEventsForMailResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalOrderEventsForMailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.russianpost.org/RTM/DataExchangeESPP/Data}PostalOrderEventsForMaiOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalOrderEventsForMailResponse", propOrder = {
    "postalOrderEventsForMaiOutput"
})
public class PostalOrderEventsForMailResponse {

    @XmlElement(name = "PostalOrderEventsForMaiOutput", namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data")
    protected PostalOrderEventsForMaiOutput postalOrderEventsForMaiOutput;

    /**
     * Gets the value of the postalOrderEventsForMaiOutput property.
     * 
     * @return
     *     possible object is
     *     {@link PostalOrderEventsForMaiOutput }
     *     
     */
    public PostalOrderEventsForMaiOutput getPostalOrderEventsForMaiOutput() {
        return postalOrderEventsForMaiOutput;
    }

    /**
     * Sets the value of the postalOrderEventsForMaiOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalOrderEventsForMaiOutput }
     *     
     */
    public void setPostalOrderEventsForMaiOutput(PostalOrderEventsForMaiOutput value) {
        this.postalOrderEventsForMaiOutput = value;
    }

}
