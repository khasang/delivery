
package net.yandex.speller.services.spellservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.yandex.speller.services.spellservice package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.yandex.speller.services.spellservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckTextResponse }
     * 
     */
    public CheckTextResponse createCheckTextResponse() {
        return new CheckTextResponse();
    }

    /**
     * Create an instance of {@link SpellResult }
     * 
     */
    public SpellResult createSpellResult() {
        return new SpellResult();
    }

    /**
     * Create an instance of {@link CheckTextsRequest }
     * 
     */
    public CheckTextsRequest createCheckTextsRequest() {
        return new CheckTextsRequest();
    }

    /**
     * Create an instance of {@link CheckTextsResponse }
     * 
     */
    public CheckTextsResponse createCheckTextsResponse() {
        return new CheckTextsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfSpellResult }
     * 
     */
    public ArrayOfSpellResult createArrayOfSpellResult() {
        return new ArrayOfSpellResult();
    }

    /**
     * Create an instance of {@link CheckTextRequest }
     * 
     */
    public CheckTextRequest createCheckTextRequest() {
        return new CheckTextRequest();
    }

    /**
     * Create an instance of {@link SpellError }
     * 
     */
    public SpellError createSpellError() {
        return new SpellError();
    }

}
