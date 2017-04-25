
package net.yandex.speller.services.spellservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpellError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpellError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="word" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="s" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="pos" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="row" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="col" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="len" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpellError", propOrder = {
    "word",
    "s"
})
public class SpellError {

    @XmlElement(required = true)
    protected String word;
    protected List<String> s;
    @XmlAttribute(name = "code", required = true)
    protected int code;
    @XmlAttribute(name = "pos", required = true)
    protected int pos;
    @XmlAttribute(name = "row", required = true)
    protected int row;
    @XmlAttribute(name = "col", required = true)
    protected int col;
    @XmlAttribute(name = "len", required = true)
    protected int len;

    /**
     * Gets the value of the word property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the value of the word property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWord(String value) {
        this.word = value;
    }

    /**
     * Gets the value of the s property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the s property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getS() {
        if (s == null) {
            s = new ArrayList<String>();
        }
        return this.s;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * Gets the value of the pos property.
     * 
     */
    public int getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     */
    public void setPos(int value) {
        this.pos = value;
    }

    /**
     * Gets the value of the row property.
     * 
     */
    public int getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     * 
     */
    public void setRow(int value) {
        this.row = value;
    }

    /**
     * Gets the value of the col property.
     * 
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets the value of the col property.
     * 
     */
    public void setCol(int value) {
        this.col = value;
    }

    /**
     * Gets the value of the len property.
     * 
     */
    public int getLen() {
        return len;
    }

    /**
     * Sets the value of the len property.
     * 
     */
    public void setLen(int value) {
        this.len = value;
    }

}
