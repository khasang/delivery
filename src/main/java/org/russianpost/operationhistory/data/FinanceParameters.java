
package org.russianpost.operationhistory.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinanceParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinanceParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Payment" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MassRate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="InsrRate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AirRate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="CustomDuty" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinanceParameters", propOrder = {
    "payment",
    "value",
    "massRate",
    "insrRate",
    "airRate",
    "rate",
    "customDuty"
})
public class FinanceParameters {

    @XmlElement(name = "Payment", required = true)
    protected BigInteger payment;
    @XmlElement(name = "Value", required = true)
    protected BigInteger value;
    @XmlElement(name = "MassRate", required = true)
    protected BigInteger massRate;
    @XmlElement(name = "InsrRate", required = true)
    protected BigInteger insrRate;
    @XmlElement(name = "AirRate", required = true)
    protected BigInteger airRate;
    @XmlElement(name = "Rate", required = true)
    protected BigInteger rate;
    @XmlElement(name = "CustomDuty", required = true)
    protected BigInteger customDuty;

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPayment(BigInteger value) {
        this.payment = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Gets the value of the massRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMassRate() {
        return massRate;
    }

    /**
     * Sets the value of the massRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMassRate(BigInteger value) {
        this.massRate = value;
    }

    /**
     * Gets the value of the insrRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInsrRate() {
        return insrRate;
    }

    /**
     * Sets the value of the insrRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInsrRate(BigInteger value) {
        this.insrRate = value;
    }

    /**
     * Gets the value of the airRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAirRate() {
        return airRate;
    }

    /**
     * Sets the value of the airRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAirRate(BigInteger value) {
        this.airRate = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRate(BigInteger value) {
        this.rate = value;
    }

    /**
     * Gets the value of the customDuty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCustomDuty() {
        return customDuty;
    }

    /**
     * Sets the value of the customDuty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCustomDuty(BigInteger value) {
        this.customDuty = value;
    }

}
