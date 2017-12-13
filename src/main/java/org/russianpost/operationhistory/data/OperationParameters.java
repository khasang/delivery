
package org.russianpost.operationhistory.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OperationParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperType" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter"/>
 *         &lt;element name="OperAttr" type="{http://russianpost.org/operationhistory/data}Rtm02Parameter"/>
 *         &lt;element name="OperDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationParameters", propOrder = {
    "operType",
    "operAttr",
    "operDate"
})
public class OperationParameters {

    @XmlElement(name = "OperType", required = true)
    protected Rtm02Parameter operType;
    @XmlElement(name = "OperAttr", required = true)
    protected Rtm02Parameter operAttr;
    @XmlElement(name = "OperDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operDate;

    /**
     * Gets the value of the operType property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getOperType() {
        return operType;
    }

    /**
     * Sets the value of the operType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setOperType(Rtm02Parameter value) {
        this.operType = value;
    }

    /**
     * Gets the value of the operAttr property.
     * 
     * @return
     *     possible object is
     *     {@link Rtm02Parameter }
     *     
     */
    public Rtm02Parameter getOperAttr() {
        return operAttr;
    }

    /**
     * Sets the value of the operAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rtm02Parameter }
     *     
     */
    public void setOperAttr(Rtm02Parameter value) {
        this.operAttr = value;
    }

    /**
     * Gets the value of the operDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperDate() {
        return operDate;
    }

    /**
     * Sets the value of the operDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperDate(XMLGregorianCalendar value) {
        this.operDate = value;
    }

}
