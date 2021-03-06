
package com.soa2.logisticstatus;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LogisticsImplService", targetNamespace = "http://services.soa2.com/", wsdlLocation = "http://localhost:8080/LogisticStatus/?wsdl")
public class LogisticsImplService
    extends Service
{

    private final static URL LOGISTICSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException LOGISTICSIMPLSERVICE_EXCEPTION;
    private final static QName LOGISTICSIMPLSERVICE_QNAME = new QName("http://services.soa2.com/", "LogisticsImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/LogisticStatus/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOGISTICSIMPLSERVICE_WSDL_LOCATION = url;
        LOGISTICSIMPLSERVICE_EXCEPTION = e;
    }

    public LogisticsImplService() {
        super(__getWsdlLocation(), LOGISTICSIMPLSERVICE_QNAME);
    }

    public LogisticsImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOGISTICSIMPLSERVICE_QNAME, features);
    }

    public LogisticsImplService(URL wsdlLocation) {
        super(wsdlLocation, LOGISTICSIMPLSERVICE_QNAME);
    }

    public LogisticsImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOGISTICSIMPLSERVICE_QNAME, features);
    }

    public LogisticsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LogisticsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LogisticsInterface
     */
    @WebEndpoint(name = "LogisticsImplPort")
    public LogisticsInterface getLogisticsImplPort() {
        return super.getPort(new QName("http://services.soa2.com/", "LogisticsImplPort"), LogisticsInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LogisticsInterface
     */
    @WebEndpoint(name = "LogisticsImplPort")
    public LogisticsInterface getLogisticsImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.soa2.com/", "LogisticsImplPort"), LogisticsInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOGISTICSIMPLSERVICE_EXCEPTION!= null) {
            throw LOGISTICSIMPLSERVICE_EXCEPTION;
        }
        return LOGISTICSIMPLSERVICE_WSDL_LOCATION;
    }

}
