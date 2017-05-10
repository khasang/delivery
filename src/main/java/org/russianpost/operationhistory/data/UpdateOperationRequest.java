
package org.russianpost.operationhistory.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateOperationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateOperationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestType" type="{http://russianpost.org/operationhistory/data}RequestType"/>
 *         &lt;element name="SourceOperation" type="{http://russianpost.org/operationhistory/data}OperationHistoryRecord"/>
 *         &lt;element name="TargetOperation" type="{http://russianpost.org/operationhistory/data}OperationHistoryRecord" minOccurs="0"/>
 *         &lt;element name="ReasonDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InitiatorDepartment" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ExecutorIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateOperationRequest", propOrder = {
    "requestType",
    "sourceOperation",
    "targetOperation",
    "reasonDescription",
    "initiatorDepartment",
    "executorIP"
})
public class UpdateOperationRequest {

    @XmlElement(name = "RequestType", required = true)
    @XmlSchemaType(name = "string")
    protected RequestType requestType;
    @XmlElement(name = "SourceOperation", required = true)
    protected OperationHistoryRecord sourceOperation;
    @XmlElement(name = "TargetOperation")
    protected OperationHistoryRecord targetOperation;
    @XmlElement(name = "ReasonDescription", required = true)
    protected String reasonDescription;
    @XmlElement(name = "InitiatorDepartment", required = true)
    protected BigInteger initiatorDepartment;
    @XmlElement(name = "ExecutorIP", required = true)
    protected String executorIP;

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link RequestType }
     *     
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestType }
     *     
     */
    public void setRequestType(RequestType value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the sourceOperation property.
     * 
     * @return
     *     possible object is
     *     {@link OperationHistoryRecord }
     *     
     */
    public OperationHistoryRecord getSourceOperation() {
        return sourceOperation;
    }

    /**
     * Sets the value of the sourceOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationHistoryRecord }
     *     
     */
    public void setSourceOperation(OperationHistoryRecord value) {
        this.sourceOperation = value;
    }

    /**
     * Gets the value of the targetOperation property.
     * 
     * @return
     *     possible object is
     *     {@link OperationHistoryRecord }
     *     
     */
    public OperationHistoryRecord getTargetOperation() {
        return targetOperation;
    }

    /**
     * Sets the value of the targetOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationHistoryRecord }
     *     
     */
    public void setTargetOperation(OperationHistoryRecord value) {
        this.targetOperation = value;
    }

    /**
     * Gets the value of the reasonDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Sets the value of the reasonDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonDescription(String value) {
        this.reasonDescription = value;
    }

    /**
     * Gets the value of the initiatorDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInitiatorDepartment() {
        return initiatorDepartment;
    }

    /**
     * Sets the value of the initiatorDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInitiatorDepartment(BigInteger value) {
        this.initiatorDepartment = value;
    }

    /**
     * Gets the value of the executorIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutorIP() {
        return executorIP;
    }

    /**
     * Sets the value of the executorIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutorIP(String value) {
        this.executorIP = value;
    }

}
