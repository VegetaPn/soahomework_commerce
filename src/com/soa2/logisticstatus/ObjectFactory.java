
package com.soa2.logisticstatus;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa2.logiticstatus package. 
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

    private final static QName _Logistics_QNAME = new QName("http://services.soa2.com/", "logistics");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa2.logiticstatus
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Logistics }
     * 
     */
    public Logistics createLogistics() {
        return new Logistics();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soa2.com/", name = "logistics")
    public JAXBElement<Logistics> createLogistics(Logistics value) {
        return new JAXBElement<Logistics>(_Logistics_QNAME, Logistics.class, null, value);
    }

}
