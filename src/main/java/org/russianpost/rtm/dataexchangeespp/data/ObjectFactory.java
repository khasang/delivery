
package org.russianpost.rtm.dataexchangeespp.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.russianpost.rtm.dataexchangeespp.data package. 
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

    private final static QName _PostalOrderEvent_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "PostalOrderEvent");
    private final static QName _PostalOrderEventsForMailInput_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "PostalOrderEventsForMailInput");
    private final static QName _Password_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "Password");
    private final static QName _Login_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "Login");
    private final static QName _PostalOrderEventsForMailError_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "PostalOrderEventsForMailError");
    private final static QName _PostalOrderEventsForMailFault_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "PostalOrderEventsForMailFault");
    private final static QName _PostalOrderEventsForMaiOutput_QNAME = new QName("http://www.russianpost.org/RTM/DataExchangeESPP/Data", "PostalOrderEventsForMaiOutput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.russianpost.rtm.dataexchangeespp.data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMailFault }
     * 
     */
    public PostalOrderEventsForMailFault createPostalOrderEventsForMailFault() {
        return new PostalOrderEventsForMailFault();
    }

    /**
     * Create an instance of {@link PostalOrderEvent }
     * 
     */
    public PostalOrderEvent createPostalOrderEvent() {
        return new PostalOrderEvent();
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMailInput }
     * 
     */
    public PostalOrderEventsForMailInput createPostalOrderEventsForMailInput() {
        return new PostalOrderEventsForMailInput();
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMaiOutput }
     * 
     */
    public PostalOrderEventsForMaiOutput createPostalOrderEventsForMaiOutput() {
        return new PostalOrderEventsForMaiOutput();
    }

    /**
     * Create an instance of {@link PostalOrderEventsForMailError }
     * 
     */
    public PostalOrderEventsForMailError createPostalOrderEventsForMailError() {
        return new PostalOrderEventsForMailError();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "PostalOrderEvent")
    public JAXBElement<PostalOrderEvent> createPostalOrderEvent(PostalOrderEvent value) {
        return new JAXBElement<PostalOrderEvent>(_PostalOrderEvent_QNAME, PostalOrderEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMailInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "PostalOrderEventsForMailInput")
    public JAXBElement<PostalOrderEventsForMailInput> createPostalOrderEventsForMailInput(PostalOrderEventsForMailInput value) {
        return new JAXBElement<PostalOrderEventsForMailInput>(_PostalOrderEventsForMailInput_QNAME, PostalOrderEventsForMailInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "Password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "Login")
    public JAXBElement<String> createLogin(String value) {
        return new JAXBElement<String>(_Login_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMailError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "PostalOrderEventsForMailError")
    public JAXBElement<PostalOrderEventsForMailError> createPostalOrderEventsForMailError(PostalOrderEventsForMailError value) {
        return new JAXBElement<PostalOrderEventsForMailError>(_PostalOrderEventsForMailError_QNAME, PostalOrderEventsForMailError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMailFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "PostalOrderEventsForMailFault")
    public JAXBElement<PostalOrderEventsForMailFault> createPostalOrderEventsForMailFault(PostalOrderEventsForMailFault value) {
        return new JAXBElement<PostalOrderEventsForMailFault>(_PostalOrderEventsForMailFault_QNAME, PostalOrderEventsForMailFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostalOrderEventsForMaiOutput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/RTM/DataExchangeESPP/Data", name = "PostalOrderEventsForMaiOutput")
    public JAXBElement<PostalOrderEventsForMaiOutput> createPostalOrderEventsForMaiOutput(PostalOrderEventsForMaiOutput value) {
        return new JAXBElement<PostalOrderEventsForMaiOutput>(_PostalOrderEventsForMaiOutput_QNAME, PostalOrderEventsForMaiOutput.class, null, value);
    }

}
