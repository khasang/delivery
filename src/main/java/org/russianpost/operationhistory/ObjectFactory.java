
package org.russianpost.operationhistory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.russianpost.operationhistory package. 
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

    private final static QName _GetCustomDutyEventsForMail_QNAME = new QName("http://russianpost.org/operationhistory", "getCustomDutyEventsForMail");
    private final static QName _GetLanguagesResponse_QNAME = new QName("http://russianpost.org/operationhistory", "getLanguagesResponse");
    private final static QName _GetCustomDutyEventsForMailResponse_QNAME = new QName("http://russianpost.org/operationhistory", "getCustomDutyEventsForMailResponse");
    private final static QName _GetSmsHistory_QNAME = new QName("http://russianpost.org/operationhistory", "getSmsHistory");
    private final static QName _GetOperationHistoryResponse_QNAME = new QName("http://russianpost.org/operationhistory", "getOperationHistoryResponse");
    private final static QName _GetLanguages_QNAME = new QName("http://russianpost.org/operationhistory", "getLanguages");
    private final static QName _GetOperationHistory_QNAME = new QName("http://russianpost.org/operationhistory", "getOperationHistory");
    private final static QName _PostalOrderEventsForMail_QNAME = new QName("http://russianpost.org/operationhistory", "PostalOrderEventsForMail");
    private final static QName _GetSmsHistoryResponse_QNAME = new QName("http://russianpost.org/operationhistory", "getSmsHistoryResponse");
    private final static QName _PostalOrderEventsForMailResponse_QNAME = new QName("http://russianpost.org/operationhistory", "PostalOrderEventsForMailResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.russianpost.operationhistory
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSmsHistory }
     * 
     */
    public GetSmsHistory createGetSmsHistory() {
        return new GetSmsHistory();
    }

    /**
     * Create an instance of {@link GetLanguagesResponse }
     * 
     */
    public GetLanguagesResponse createGetLanguagesResponse() {
        return new GetLanguagesResponse();
    }

    /**
     * Create an instance of {@link GetCustomDutyEventsForMail }
     * 
     */
    public GetCustomDutyEventsForMail createGetCustomDutyEventsForMail() {
        return new GetCustomDutyEventsForMail();
    }

    /**
     * Create an instance of {@link GetCustomDutyEventsForMailResponse }
     * 
     */
    public GetCustomDutyEventsForMailResponse createGetCustomDutyEventsForMailResponse() {
        return new GetCustomDutyEventsForMailResponse();
    }

    /**
     * Create an instance of {@link GetOperationHistory }
     * 
     */
    public GetOperationHistory createGetOperationHistory() {
        return new GetOperationHistory();
    }

    /**
     * Create an instance of {@link GetLanguages }
     * 
     */
    public GetLanguages createGetLanguages() {
        return new GetLanguages();
    }

    /**
     * Create an instance of {@link GetOperationHistoryResponse }
     * 
     */
    public GetOperationHistoryResponse createGetOperationHistoryResponse() {
        return new GetOperationHistoryResponse();
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMailResponse }
     * 
     */
    public PostalOrderEventsForMailResponse createPostalOrderEventsForMailResponse() {
        return new PostalOrderEventsForMailResponse();
    }

    /**
     * Create an instance of {@link GetSmsHistoryResponse }
     * 
     */
    public GetSmsHistoryResponse createGetSmsHistoryResponse() {
        return new GetSmsHistoryResponse();
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMail }
     * 
     */
    public PostalOrderEventsForMail createPostalOrderEventsForMail() {
        return new PostalOrderEventsForMail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomDutyEventsForMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getCustomDutyEventsForMail")
    public JAXBElement<GetCustomDutyEventsForMail> createGetCustomDutyEventsForMail(GetCustomDutyEventsForMail value) {
        return new JAXBElement<GetCustomDutyEventsForMail>(_GetCustomDutyEventsForMail_QNAME, GetCustomDutyEventsForMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getLanguagesResponse")
    public JAXBElement<GetLanguagesResponse> createGetLanguagesResponse(GetLanguagesResponse value) {
        return new JAXBElement<GetLanguagesResponse>(_GetLanguagesResponse_QNAME, GetLanguagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomDutyEventsForMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getCustomDutyEventsForMailResponse")
    public JAXBElement<GetCustomDutyEventsForMailResponse> createGetCustomDutyEventsForMailResponse(GetCustomDutyEventsForMailResponse value) {
        return new JAXBElement<GetCustomDutyEventsForMailResponse>(_GetCustomDutyEventsForMailResponse_QNAME, GetCustomDutyEventsForMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSmsHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getSmsHistory")
    public JAXBElement<GetSmsHistory> createGetSmsHistory(GetSmsHistory value) {
        return new JAXBElement<GetSmsHistory>(_GetSmsHistory_QNAME, GetSmsHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getOperationHistoryResponse")
    public JAXBElement<GetOperationHistoryResponse> createGetOperationHistoryResponse(GetOperationHistoryResponse value) {
        return new JAXBElement<GetOperationHistoryResponse>(_GetOperationHistoryResponse_QNAME, GetOperationHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLanguages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getLanguages")
    public JAXBElement<GetLanguages> createGetLanguages(GetLanguages value) {
        return new JAXBElement<GetLanguages>(_GetLanguages_QNAME, GetLanguages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperationHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getOperationHistory")
    public JAXBElement<GetOperationHistory> createGetOperationHistory(GetOperationHistory value) {
        return new JAXBElement<GetOperationHistory>(_GetOperationHistory_QNAME, GetOperationHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "PostalOrderEventsForMail")
    public JAXBElement<PostalOrderEventsForMail> createPostalOrderEventsForMail(PostalOrderEventsForMail value) {
        return new JAXBElement<PostalOrderEventsForMail>(_PostalOrderEventsForMail_QNAME, PostalOrderEventsForMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSmsHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "getSmsHistoryResponse")
    public JAXBElement<GetSmsHistoryResponse> createGetSmsHistoryResponse(GetSmsHistoryResponse value) {
        return new JAXBElement<GetSmsHistoryResponse>(_GetSmsHistoryResponse_QNAME, GetSmsHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/operationhistory", name = "PostalOrderEventsForMailResponse")
    public JAXBElement<PostalOrderEventsForMailResponse> createPostalOrderEventsForMailResponse(PostalOrderEventsForMailResponse value) {
        return new JAXBElement<PostalOrderEventsForMailResponse>(_PostalOrderEventsForMailResponse_QNAME, PostalOrderEventsForMailResponse.class, null, value);
    }

}
