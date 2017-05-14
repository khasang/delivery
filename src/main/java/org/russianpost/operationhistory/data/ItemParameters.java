
package org.russianpost.operationhistory.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Barcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Internum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidRuType" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ValidEnType" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ComplexItemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MailRank" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter" minOccurs="0"/>
 *         &lt;element name="PostMark" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter"/>
 *         &lt;element name="MailType" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter"/>
 *         &lt;element name="MailCtg" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter"/>
 *         &lt;element name="Mass" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MaxMassRU" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MaxMassEN" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemParameters", propOrder = {
    "barcode",
    "internum",
    "validRuType",
    "validEnType",
    "complexItemName",
    "mailRank",
    "postMark",
    "mailType",
    "mailCtg",
    "mass",
    "maxMassRU",
    "maxMassEN"
})
public class ItemParameters {

    @XmlElement(name = "Barcode", required = true)
    protected String barcode;
    @XmlElement(name = "Internum")
    protected String internum;
    @XmlElement(name = "ValidRuType")
    protected boolean validRuType;
    @XmlElement(name = "ValidEnType")
    protected boolean validEnType;
    @XmlElement(name = "ComplexItemName", required = true)
    protected String complexItemName;
    @XmlElement(name = "MailRank")
    protected Rtm02Parameter mailRank;
    @XmlElement(name = "PostMark", required = true)
    protected Rtm02Parameter postMark;
    @XmlElement(name = "MailType", required = true)
    protected Rtm02Parameter mailType;
    @XmlElement(name = "MailCtg", required = true)
    protected Rtm02Parameter mailCtg;
    @XmlElement(name = "Mass", required = true)
    protected BigInteger mass;
    @XmlElement(name = "MaxMassRU", required = true)
    protected BigInteger maxMassRU;
    @XmlElement(name = "MaxMassEN", required = true)
    protected BigInteger maxMassEN;

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the internum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternum() {
        return internum;
    }

    /**
     * Sets the value of the internum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternum(String value) {
        this.internum = value;
    }

    /**
     * Gets the value of the validRuType property.
     * 
     */
    public boolean isValidRuType() {
        return validRuType;
    }

    /**
     * Sets the value of the validRuType property.
     * 
     */
    public void setValidRuType(boolean value) {
        this.validRuType = value;
    }

    /**
     * Gets the value of the validEnType property.
     * 
     */
    public boolean isValidEnType() {
        return validEnType;
    }

    /**
     * Sets the value of the validEnType property.
     * 
     */
    public void setValidEnType(boolean value) {
        this.validEnType = value;
    }

    /**
     * Gets the value of the complexItemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplexItemName() {
        return complexItemName;
    }

    /**
     * Sets the value of the complexItemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplexItemName(String value) {
        this.complexItemName = value;
    }

    /**
     * Gets the value of the mailRank property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getMailRank() {
        return mailRank;
    }

    /**
     * Sets the value of the mailRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setMailRank(Rtm02Parameter value) {
        this.mailRank = value;
    }

    /**
     * Gets the value of the postMark property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getPostMark() {
        return postMark;
    }

    /**
     * Sets the value of the postMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setPostMark(Rtm02Parameter value) {
        this.postMark = value;
    }

    /**
     * Gets the value of the mailType property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getMailType() {
        return mailType;
    }

    /**
     * Sets the value of the mailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setMailType(Rtm02Parameter value) {
        this.mailType = value;
    }

    /**
     * Gets the value of the mailCtg property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getMailCtg() {
        return mailCtg;
    }

    /**
     * Sets the value of the mailCtg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setMailCtg(Rtm02Parameter value) {
        this.mailCtg = value;
    }

    /**
     * Gets the value of the mass property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMass() {
        return mass;
    }

    /**
     * Sets the value of the mass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMass(BigInteger value) {
        this.mass = value;
    }

    /**
     * Gets the value of the maxMassRU property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxMassRU() {
        return maxMassRU;
    }

    /**
     * Sets the value of the maxMassRU property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxMassRU(BigInteger value) {
        this.maxMassRU = value;
    }

    /**
     * Gets the value of the maxMassEN property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxMassEN() {
        return maxMassEN;
    }

    /**
     * Sets the value of the maxMassEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxMassEN(BigInteger value) {
        this.maxMassEN = value;
    }

}
