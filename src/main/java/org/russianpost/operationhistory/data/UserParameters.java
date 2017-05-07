
package org.russianpost.operationhistory.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SendCtg" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter" minOccurs="0"/>
 *         &lt;element name="Sndr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rcpn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserParameters", propOrder = {
    "sendCtg",
    "sndr",
    "rcpn"
})
public class UserParameters {

    @XmlElement(name = "SendCtg")
    protected Rtm02Parameter sendCtg;
    @XmlElement(name = "Sndr")
    protected String sndr;
    @XmlElement(name = "Rcpn")
    protected String rcpn;

    /**
     * Gets the value of the sendCtg property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getSendCtg() {
        return sendCtg;
    }

    /**
     * Sets the value of the sendCtg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setSendCtg(Rtm02Parameter value) {
        this.sendCtg = value;
    }

    /**
     * Gets the value of the sndr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSndr() {
        return sndr;
    }

    /**
     * Sets the value of the sndr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSndr(String value) {
        this.sndr = value;
    }

    /**
     * Gets the value of the rcpn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcpn() {
        return rcpn;
    }

    /**
     * Sets the value of the rcpn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcpn(String value) {
        this.rcpn = value;
    }

}
