
package net.yandex.speller.services.spellservice;

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
 *         &lt;element name="SpellResult" type="{http://speller.yandex.net/services/spellservice}SpellResult"/>
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
    "spellResult"
})
@XmlRootElement(name = "CheckTextResponse")
public class CheckTextResponse {

    @XmlElement(name = "SpellResult", required = true)
    protected SpellResult spellResult;

    /**
     * Gets the value of the spellResult property.
     * 
     * @return
     *     possible object is
     *     {@link SpellResult }
     *     
     */
    public SpellResult getSpellResult() {
        return spellResult;
    }

    /**
     * Sets the value of the spellResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpellResult }
     *     
     */
    public void setSpellResult(SpellResult value) {
        this.spellResult = value;
    }

}
