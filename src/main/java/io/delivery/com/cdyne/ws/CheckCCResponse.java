
package io.delivery.com.cdyne.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckCCResult" type="{http://ws.cdyne.com/}ReturnIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnIndicatorResult"
})
@XmlRootElement(name = "CheckCCResponse")
public class CheckCCResponse {

    @XmlElement(name = "CheckCCResult")
    protected ReturnIndicator returnIndicatorResult;

    /**
     * Gets the value of the checkCCResult property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnIndicator }
     *     
     */
    public ReturnIndicator getReturnIndicatorResult() {
        return returnIndicatorResult;
    }

    /**
     * Sets the value of the checkCCResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnIndicator }
     *     
     */
    public void setReturnIndicatorResult(ReturnIndicator value) {
        this.returnIndicatorResult = value;
    }

}
