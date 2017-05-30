
package org.russianpost.operationhistory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.russianpost.operationhistory.data.AuthorizationHeader;
import org.russianpost.operationhistory.data.OperationHistoryRequest;


/**
 * <p>Java class for getOperationHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getOperationHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}OperationHistoryRequest" minOccurs="0"/>
 *         &lt;element ref="{http://russianpost.org/operationhistory/data}AuthorizationHeader" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOperationHistory", propOrder = {
    "operationHistoryRequest",
    "authorizationHeader"
})
public class GetOperationHistory {

    @XmlElement(name = "OperationHistoryRequest", namespace = "http://russianpost.org/operationhistory/data")
    protected OperationHistoryRequest operationHistoryRequest;
    @XmlElement(name = "AuthorizationHeader", namespace = "http://russianpost.org/operationhistory/data")
    protected AuthorizationHeader authorizationHeader;

    /**
     * Gets the value of the operationHistoryRequest property.
     * 
     * @return
     *     possible object is
     *     {@link OperationHistoryRequest }
     *     
     */
    public OperationHistoryRequest getOperationHistoryRequest() {
        return operationHistoryRequest;
    }

    /**
     * Sets the value of the operationHistoryRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationHistoryRequest }
     *     
     */
    public void setOperationHistoryRequest(OperationHistoryRequest value) {
        this.operationHistoryRequest = value;
    }

    /**
     * Gets the value of the authorizationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationHeader }
     *     
     */
    public AuthorizationHeader getAuthorizationHeader() {
        return authorizationHeader;
    }

    /**
     * Sets the value of the authorizationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationHeader }
     *     
     */
    public void setAuthorizationHeader(AuthorizationHeader value) {
        this.authorizationHeader = value;
    }

}
