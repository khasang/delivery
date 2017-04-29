
package t320.nks34;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the t320.nks34 package. 
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

    private final static QName _HelloNameResponseReturn_QNAME = new QName("http://nks34.t320", "return");
    private final static QName _HelloNameName_QNAME = new QName("http://nks34.t320", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: t320.nks34
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloNameResponse }
     * 
     */
    public HelloNameResponse createHelloNameResponse() {
        return new HelloNameResponse();
    }

    /**
     * Create an instance of {@link HelloName }
     * 
     */
    public HelloName createHelloName() {
        return new HelloName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nks34.t320", name = "return", scope = HelloNameResponse.class)
    public JAXBElement<String> createHelloNameResponseReturn(String value) {
        return new JAXBElement<String>(_HelloNameResponseReturn_QNAME, String.class, HelloNameResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nks34.t320", name = "name", scope = HelloName.class)
    public JAXBElement<String> createHelloNameName(String value) {
        return new JAXBElement<String>(_HelloNameName_QNAME, String.class, HelloName.class, value);
    }

}
