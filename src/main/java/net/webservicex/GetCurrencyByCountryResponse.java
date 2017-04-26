
package net.webservicex;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="GetCurrencyByCountryResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCurrencyByCountryResult"
})
@XmlRootElement(name = "GetCurrencyByCountryResponse")
public class GetCurrencyByCountryResponse {

    @XmlElement(name = "GetCurrencyByCountryResult")
    protected String getCurrencyByCountryResult;

    /**
     * Gets the value of the getCurrencyByCountryResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCurrencyByCountryResult() {
        return getCurrencyByCountryResult;
    }

    /**
     * Sets the value of the getCurrencyByCountryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCurrencyByCountryResult(String value) {
        this.getCurrencyByCountryResult = value;
    }

}
