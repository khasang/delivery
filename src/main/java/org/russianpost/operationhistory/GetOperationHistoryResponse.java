
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.operationhistory.data.OperationHistoryData;


/**
 * <p>Java class for getOperationHistoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getOperationHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}OperationHistoryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOperationHistoryResponse", propOrder = {
    "operationHistoryData"
})
public class GetOperationHistoryResponse {

    @XmlElement(name = "OperationHistoryData", namespace = "http://russianpost.org/operationhistory/data")
    protected OperationHistoryData operationHistoryData;

    /**
     * Gets the value of the operationHistoryData property.
     * 
     * @return
     *     possible object is
     *     {@link OperationHistoryData }
     *     
     */
    public OperationHistoryData getOperationHistoryData() {
        return operationHistoryData;
    }

    /**
     * Sets the value of the operationHistoryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationHistoryData }
     *     
     */
    public void setOperationHistoryData(OperationHistoryData value) {
        this.operationHistoryData = value;
    }

}
