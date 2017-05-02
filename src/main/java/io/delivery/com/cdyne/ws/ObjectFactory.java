
package io.delivery.com.cdyne.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cdyne.ws package. 
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

    private final static QName _ReturnIndicator_QNAME = new QName("http://ws.cdyne.com/", "ReturnIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cdyne.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckCCResponse }
     * 
     */
    public CheckCCResponse createCheckCCResponse() {
        return new CheckCCResponse();
    }

    /**
     * Create an instance of {@link ReturnIndicator }
     * 
     */
    public ReturnIndicator createReturnIndicator() {
        return new ReturnIndicator();
    }

    /**
     * Create an instance of {@link CheckCC }
     * 
     */
    public CheckCC createCheckCC() {
        return new CheckCC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnIndicator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/", name = "ReturnIndicator")
    public JAXBElement<ReturnIndicator> createReturnIndicator(ReturnIndicator value) {
        return new JAXBElement<ReturnIndicator>(_ReturnIndicator_QNAME, ReturnIndicator.class, null, value);
    }

}
