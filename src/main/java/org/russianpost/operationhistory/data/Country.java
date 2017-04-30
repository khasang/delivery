
package org.russianpost.operationhistory.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Country complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Country">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Code2A" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Code3A" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameRU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Country", propOrder = {
    "id",
    "code2A",
    "code3A",
    "name",
    "nameRU",
    "nameEN"
})
public class Country {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Code2A")
    protected String code2A;
    @XmlElement(name = "Code3A")
    protected String code3A;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "NameRU")
    protected String nameRU;
    @XmlElement(name = "NameEN")
    protected String nameEN;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the code2A property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode2A() {
        return code2A;
    }

    /**
     * Sets the value of the code2A property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode2A(String value) {
        this.code2A = value;
    }

    /**
     * Gets the value of the code3A property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode3A() {
        return code3A;
    }

    /**
     * Sets the value of the code3A property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode3A(String value) {
        this.code3A = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nameRU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameRU() {
        return nameRU;
    }

    /**
     * Sets the value of the nameRU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameRU(String value) {
        this.nameRU = value;
    }

    /**
     * Gets the value of the nameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEN() {
        return nameEN;
    }

    /**
     * Sets the value of the nameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEN(String value) {
        this.nameEN = value;
    }

}
