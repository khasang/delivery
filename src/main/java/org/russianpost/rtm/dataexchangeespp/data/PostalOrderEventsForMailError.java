
package org.russianpost.rtm.dataexchangeespp.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostalOrderEventsForMailError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalOrderEventsForMailError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ErrorID" type="{http://www.russianpost.org/RTM/DataExchangeESPP/Data}PostalOrderEventsForMailErrors" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalOrderEventsForMailError")
public class PostalOrderEventsForMailError {

    @XmlAttribute(name = "ErrorID")
    protected PostalOrderEventsForMailErrors errorID;

    /**
     * Gets the value of the errorID property.
     * 
     * @return
     *     possible object is
     *     {@link PostalOrderEventsForMailErrors }
     *     
     */
    public PostalOrderEventsForMailErrors getErrorID() {
        return errorID;
    }

    /**
     * Sets the value of the errorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalOrderEventsForMailErrors }
     *     
     */
    public void setErrorID(PostalOrderEventsForMailErrors value) {
        this.errorID = value;
    }

}
