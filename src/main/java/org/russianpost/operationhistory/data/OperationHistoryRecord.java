
package org.russianpost.operationhistory.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationHistoryRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationHistoryRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressParameters" type="{http://russianpost.org/operationhistory/data}AddressParameters"/>
 *         &lt;element name="FinanceParameters" type="{http://russianpost.org/operationhistory/data}FinanceParameters"/>
 *         &lt;element name="ItemParameters" type="{http://russianpost.org/operationhistory/data}ItemParameters"/>
 *         &lt;element name="OperationParameters" type="{http://russianpost.org/operationhistory/data}OperationParameters"/>
 *         &lt;element name="UserParameters" type="{http://russianpost.org/operationhistory/data}UserParameters"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationHistoryRecord", propOrder = {
    "addressParameters",
    "financeParameters",
    "itemParameters",
    "operationParameters",
    "userParameters"
})
public class OperationHistoryRecord {

    @XmlElement(name = "AddressParameters", required = true)
    protected AddressParameters addressParameters;
    @XmlElement(name = "FinanceParameters", required = true)
    protected FinanceParameters financeParameters;
    @XmlElement(name = "ItemParameters", required = true)
    protected ItemParameters itemParameters;
    @XmlElement(name = "OperationParameters", required = true)
    protected OperationParameters operationParameters;
    @XmlElement(name = "UserParameters", required = true)
    protected UserParameters userParameters;

    /**
     * Gets the value of the addressParameters property.
     * 
     * @return
     *     possible object is
     *     {@link AddressParameters }
     *     
     */
    public AddressParameters getAddressParameters() {
        return addressParameters;
    }

    /**
     * Sets the value of the addressParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressParameters }
     *     
     */
    public void setAddressParameters(AddressParameters value) {
        this.addressParameters = value;
    }

    /**
     * Gets the value of the financeParameters property.
     * 
     * @return
     *     possible object is
     *     {@link FinanceParameters }
     *     
     */
    public FinanceParameters getFinanceParameters() {
        return financeParameters;
    }

    /**
     * Sets the value of the financeParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinanceParameters }
     *     
     */
    public void setFinanceParameters(FinanceParameters value) {
        this.financeParameters = value;
    }

    /**
     * Gets the value of the itemParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ItemParameters }
     *     
     */
    public ItemParameters getItemParameters() {
        return itemParameters;
    }

    /**
     * Sets the value of the itemParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemParameters }
     *     
     */
    public void setItemParameters(ItemParameters value) {
        this.itemParameters = value;
    }

    /**
     * Gets the value of the operationParameters property.
     * 
     * @return
     *     possible object is
     *     {@link OperationParameters }
     *     
     */
    public OperationParameters getOperationParameters() {
        return operationParameters;
    }

    /**
     * Sets the value of the operationParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationParameters }
     *     
     */
    public void setOperationParameters(OperationParameters value) {
        this.operationParameters = value;
    }

    /**
     * Gets the value of the userParameters property.
     * 
     * @return
     *     possible object is
     *     {@link UserParameters }
     *     
     */
    public UserParameters getUserParameters() {
        return userParameters;
    }

    /**
     * Sets the value of the userParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserParameters }
     *     
     */
    public void setUserParameters(UserParameters value) {
        this.userParameters = value;
    }

}
