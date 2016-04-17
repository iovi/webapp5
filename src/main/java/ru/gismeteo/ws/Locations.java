
package ru.gismeteo.ws;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Locations", targetNamespace = "http://ws.gismeteo.ru/", wsdlLocation = "http://ws.gismeteo.ru/Locations/Locations.asmx?WSDL")
public class Locations
    extends Service
{

    private final static URL LOCATIONS_WSDL_LOCATION;
    private final static WebServiceException LOCATIONS_EXCEPTION;
    private final static QName LOCATIONS_QNAME = new QName("http://ws.gismeteo.ru/", "Locations");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://ws.gismeteo.ru/Locations/Locations.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOCATIONS_WSDL_LOCATION = url;
        LOCATIONS_EXCEPTION = e;
    }

    public Locations() {
        super(__getWsdlLocation(), LOCATIONS_QNAME);
    }

    public Locations(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOCATIONS_QNAME, features);
    }

    public Locations(URL wsdlLocation) {
        super(wsdlLocation, LOCATIONS_QNAME);
    }

    public Locations(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOCATIONS_QNAME, features);
    }

    public Locations(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Locations(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LocationsSoap
     */
    @WebEndpoint(name = "LocationsSoap")
    public LocationsSoap getLocationsSoap() {
        return super.getPort(new QName("http://ws.gismeteo.ru/", "LocationsSoap"), LocationsSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LocationsSoap
     */
    @WebEndpoint(name = "LocationsSoap")
    public LocationsSoap getLocationsSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.gismeteo.ru/", "LocationsSoap"), LocationsSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOCATIONS_EXCEPTION!= null) {
            throw LOCATIONS_EXCEPTION;
        }
        return LOCATIONS_WSDL_LOCATION;
    }

}
