
package org.russianpost.custom_duty_info.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomDutyEventsForMailErrors.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomDutyEventsForMailErrors">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BarcodeIsNull"/>
 *     &lt;enumeration value="InternalServiceError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomDutyEventsForMailErrors")
@XmlEnum
public enum CustomDutyEventsForMailErrors {

    @XmlEnumValue("BarcodeIsNull")
    BARCODE_IS_NULL("BarcodeIsNull"),
    @XmlEnumValue("InternalServiceError")
    INTERNAL_SERVICE_ERROR("InternalServiceError");
    private final String value;

    CustomDutyEventsForMailErrors(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomDutyEventsForMailErrors fromValue(String v) {
        for (CustomDutyEventsForMailErrors c: CustomDutyEventsForMailErrors.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
