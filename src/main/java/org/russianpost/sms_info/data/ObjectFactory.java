
package org.russianpost.sms_info.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.russianpost.sms_info.data package. 
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

    private final static QName _SmsHistoryFaultReason_QNAME = new QName("http://russianpost.org/sms-info/data", "SmsHistoryFaultReason");
    private final static QName _LanguageFaultReason_QNAME = new QName("http://russianpost.org/sms-info/data", "LanguageFaultReason");
    private final static QName _AuthorisationFaultReason_QNAME = new QName("http://russianpost.org/sms-info/data", "AuthorisationFaultReason");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.russianpost.sms_info.data
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
     * Create an instance of {@link SmsHistoryRequest }
     * 
     */
    public SmsHistoryRequest createSmsHistoryRequest() {
        return new SmsHistoryRequest();
    }

    /**
     * Create an instance of {@link SmsHistoryData }
     * 
     */
    public SmsHistoryData createSmsHistoryData() {
        return new SmsHistoryData();
    }

    /**
     * Create an instance of {@link SmsHistoryRecord }
     * 
     */
    public SmsHistoryRecord createSmsHistoryRecord() {
        return new SmsHistoryRecord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/sms-info/data", name = "SmsHistoryFaultReason")
    public JAXBElement<String> createSmsHistoryFaultReason(String value) {
        return new JAXBElement<String>(_SmsHistoryFaultReason_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/sms-info/data", name = "LanguageFaultReason")
    public JAXBElement<String> createLanguageFaultReason(String value) {
        return new JAXBElement<String>(_LanguageFaultReason_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://russianpost.org/sms-info/data", name = "AuthorisationFaultReason")
    public JAXBElement<String> createAuthorisationFaultReason(String value) {
        return new JAXBElement<String>(_AuthorisationFaultReason_QNAME, String.class, null, value);
    }

}
