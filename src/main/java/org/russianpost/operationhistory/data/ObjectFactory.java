
package org.russianpost.operationhistory.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.russianpost.operationhistory.data package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LanguageFaultReason_QNAME = new QName("http://russianpost.org/operationhistory/data", "LanguageFaultReason");
    private final static QName _UpdateOperationRequest_QNAME = new QName("http://russianpost.org/operationhistory/data", "UpdateOperationRequest");
    private final static QName _AuthorizationFaultReason_QNAME = new QName("http://russianpost.org/operationhistory/data", "AuthorizationFaultReason");
    private final static QName _OperationHistoryFaultReason_QNAME = new QName("http://russianpost.org/operationhistory/data", "OperationHistoryFaultReason");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.russianpost.operationhistory.data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LanguageData }
     * 
     */
    public LanguageData createLanguageData() {
        return new LanguageData();
    }

    /**
     * Create an instance of {@link LanguageData.Language }
     * 
     */
    public LanguageData.Language createLanguageDataLanguage() {
        return new LanguageData.Language();
    }

    /**
     * Create an instance of {@link AuthorizationHeader }
     * 
     */
    public AuthorizationHeader createAuthorizationHeader() {
        return new AuthorizationHeader();
    }

    /**
     * Create an instance of {@link OperationHistoryRequest }
     * 
     */
    public OperationHistoryRequest createOperationHistoryRequest() {
        return new OperationHistoryRequest();
    }

    /**
     * Create an instance of {@link UpdateOperationRequest }
     * 
     */
    public UpdateOperationRequest createUpdateOperationRequest() {
        return new UpdateOperationRequest();
    }

    /**
     * Create an instance of {@link OperationHistoryData }
     * 
     */
    public OperationHistoryData createOperationHistoryData() {
        return new OperationHistoryData();
    }

    /**
     * Create an instance of {@link OperationHistoryRecord }
     * 
     */
    public OperationHistoryRecord createOperationHistoryRecord() {
        return new OperationHistoryRecord();
    }

    /**
     * Create an instance of {@link ItemParameters }
     * 
     */
    public ItemParameters createItemParameters() {
        return new ItemParameters();
    }

    /**
     * Create an instance of {@link UserParameters }
     * 
     */
    public UserParameters createUserParameters() {
        return new UserParameters();
    }

    /**
     * Create an instance of {@link AddressParameters }
     * 
     */
    public AddressParameters createAddressParameters() {
        return new AddressParameters();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link OperationParameters }
     * 
     */
    public OperationParameters createOperationParameters() {
        return new OperationParameters();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Rtm02Parameter }
     * 
     */
    public Rtm02Parameter createRtm02Parameter() {
        return new Rtm02Parameter();
    }

    /**
     * Create an instance of {@link FinanceParameters }
     * 
     */
    public FinanceParameters createFinanceParameters() {
        return new FinanceParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory/data", name = "LanguageFaultReason")
    public JAXBElement<String> createLanguageFaultReason(String value) {
        return new JAXBElement<String>(_LanguageFaultReason_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOperationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory/data", name = "UpdateOperationRequest")
    public JAXBElement<UpdateOperationRequest> createUpdateOperationRequest(UpdateOperationRequest value) {
        return new JAXBElement<UpdateOperationRequest>(_UpdateOperationRequest_QNAME, UpdateOperationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory/data", name = "AuthorizationFaultReason")
    public JAXBElement<String> createAuthorizationFaultReason(String value) {
        return new JAXBElement<String>(_AuthorizationFaultReason_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory/data", name = "OperationHistoryFaultReason")
    public JAXBElement<String> createOperationHistoryFaultReason(String value) {
        return new JAXBElement<String>(_OperationHistoryFaultReason_QNAME, String.class, null, value);
    }

}
