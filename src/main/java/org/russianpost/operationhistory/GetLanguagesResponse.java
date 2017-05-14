
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.operationhistory.data.LanguageData;


/**
 * <p>Java class for getLanguagesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLanguagesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}LanguageData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLanguagesResponse", propOrder = {
    "languageData"
})
public class GetLanguagesResponse {

    @XmlElement(name = "LanguageData", namespace = "http://russianpost.org/operationhistory/data")
    protected LanguageData languageData;

    /**
     * Gets the value of the languageData property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageData }
     *     
     */
    public LanguageData getLanguageData() {
        return languageData;
    }

    /**
     * Sets the value of the languageData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageData }
     *     
     */
    public void setLanguageData(LanguageData value) {
        this.languageData = value;
    }

}
