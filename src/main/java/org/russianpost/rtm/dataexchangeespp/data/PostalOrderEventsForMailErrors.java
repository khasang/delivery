
package org.russianpost.rtm.dataexchangeespp.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostalOrderEventsForMailErrors.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PostalOrderEventsForMailErrors">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="InvalidLoginOrPassword"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PostalOrderEventsForMailErrors")
@XmlEnum
public enum PostalOrderEventsForMailErrors {

    @XmlEnumValue("InvalidLoginOrPassword")
    INVALID_LOGIN_OR_PASSWORD("InvalidLoginOrPassword");
    private final String value;

    PostalOrderEventsForMailErrors(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PostalOrderEventsForMailErrors fromValue(String v) {
        for (PostalOrderEventsForMailErrors c: PostalOrderEventsForMailErrors.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
