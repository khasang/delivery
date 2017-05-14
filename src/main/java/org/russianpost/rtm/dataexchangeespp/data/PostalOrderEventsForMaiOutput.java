
package org.russianpost.rtm.dataexchangeespp.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostalOrderEventsForMaiOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalOrderEventsForMaiOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PostalOrderEvent" type="{http://www.russianpost.org/RTM/DataExchangeESPP/Data}PostalOrderEvent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalOrderEventsForMaiOutput", propOrder = {
    "postalOrderEvent"
})
public class PostalOrderEventsForMaiOutput {

    @XmlElement(name = "PostalOrderEvent")
    protected List<PostalOrderEvent> postalOrderEvent;

    /**
     * Gets the value of the postalOrderEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postalOrderEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostalOrderEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostalOrderEvent }
     * 
     * 
     */
    public List<PostalOrderEvent> getPostalOrderEvent() {
        if (postalOrderEvent == null) {
            postalOrderEvent = new ArrayList<PostalOrderEvent>();
        }
        return this.postalOrderEvent;
    }

}
