
package org.russianpost.custom_duty_info.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.russianpost.custom_duty_info.data package. 
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

    private final static QName _CustomDutyEvent_QNAME = new QName("http://www.russianpost.org/custom-duty-info/data", "CustomDutyEvent");
    private final static QName _CustomDutyEventsForMailOutput_QNAME = new QName("http://www.russianpost.org/custom-duty-info/data", "CustomDutyEventsForMailOutput");
    private final static QName _CustomDutyEventsForMailFault_QNAME = new QName("http://www.russianpost.org/custom-duty-info/data", "CustomDutyEventsForMailFault");
    private final static QName _CustomDutyEventsForMailInput_QNAME = new QName("http://www.russianpost.org/custom-duty-info/data", "CustomDutyEventsForMailInput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.russianpost.custom_duty_info.data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomDutyEventsForMailFault }
     * 
     */
    public CustomDutyEventsForMailFault createCustomDutyEventsForMailFault() {
        return new CustomDutyEventsForMailFault();
    }

    /**
     * Create an instance of {@link CustomDutyEvent }
     * 
     */
    public CustomDutyEvent createCustomDutyEvent() {
        return new CustomDutyEvent();
    }

    /**
     * Create an instance of {@link CustomDutyEventsForMailInput }
     * 
     */
    public CustomDutyEventsForMailInput createCustomDutyEventsForMailInput() {
        return new CustomDutyEventsForMailInput();
    }

    /**
     * Create an instance of {@link CustomDutyEventsForMailOutput }
     * 
     */
    public CustomDutyEventsForMailOutput createCustomDutyEventsForMailOutput() {
        return new CustomDutyEventsForMailOutput();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDutyEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/custom-duty-info/data", name = "CustomDutyEvent")
    public JAXBElement<CustomDutyEvent> createCustomDutyEvent(CustomDutyEvent value) {
        return new JAXBElement<CustomDutyEvent>(_CustomDutyEvent_QNAME, CustomDutyEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDutyEventsForMailOutput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/custom-duty-info/data", name = "CustomDutyEventsForMailOutput")
    public JAXBElement<CustomDutyEventsForMailOutput> createCustomDutyEventsForMailOutput(CustomDutyEventsForMailOutput value) {
        return new JAXBElement<CustomDutyEventsForMailOutput>(_CustomDutyEventsForMailOutput_QNAME, CustomDutyEventsForMailOutput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDutyEventsForMailFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/custom-duty-info/data", name = "CustomDutyEventsForMailFault")
    public JAXBElement<CustomDutyEventsForMailFault> createCustomDutyEventsForMailFault(CustomDutyEventsForMailFault value) {
        return new JAXBElement<CustomDutyEventsForMailFault>(_CustomDutyEventsForMailFault_QNAME, CustomDutyEventsForMailFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomDutyEventsForMailInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.russianpost.org/custom-duty-info/data", name = "CustomDutyEventsForMailInput")
    public JAXBElement<CustomDutyEventsForMailInput> createCustomDutyEventsForMailInput(CustomDutyEventsForMailInput value) {
        return new JAXBElement<CustomDutyEventsForMailInput>(_CustomDutyEventsForMailInput_QNAME, CustomDutyEventsForMailInput.class, null, value);
    }

}
