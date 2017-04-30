
package org.russianpost.custom_duty_info.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomDutyEventsForMailOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomDutyEventsForMailOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomDutyEvent" type="{http://www.russianpost.org/custom-duty-info/data}CustomDutyEvent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomDutyEventsForMailOutput", propOrder = {
    "customDutyEvent"
})
public class CustomDutyEventsForMailOutput {

    @XmlElement(name = "CustomDutyEvent")
    protected List<CustomDutyEvent> customDutyEvent;

    /**
     * Gets the value of the customDutyEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customDutyEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomDutyEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomDutyEvent }
     * 
     * 
     */
    public List<CustomDutyEvent> getCustomDutyEvent() {
        if (customDutyEvent == null) {
            customDutyEvent = new ArrayList<CustomDutyEvent>();
        }
        return this.customDutyEvent;
    }

}
