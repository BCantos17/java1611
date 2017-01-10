
package com.revature.soap_server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.revature.soap_server package. 
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

    private final static QName _SayHi_QNAME = new QName("http://soap_server.revature.com/", "sayHi");
    private final static QName _SayHiResponse_QNAME = new QName("http://soap_server.revature.com/", "sayHiResponse");
    private final static QName _Work_QNAME = new QName("http://soap_server.revature.com/", "work");
    private final static QName _WorkResponse_QNAME = new QName("http://soap_server.revature.com/", "workResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.soap_server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link Work }
     * 
     */
    public Work createWork() {
        return new Work();
    }

    /**
     * Create an instance of {@link WorkResponse }
     * 
     */
    public WorkResponse createWorkResponse() {
        return new WorkResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.revature.com/", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.revature.com/", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Work }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.revature.com/", name = "work")
    public JAXBElement<Work> createWork(Work value) {
        return new JAXBElement<Work>(_Work_QNAME, Work.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_server.revature.com/", name = "workResponse")
    public JAXBElement<WorkResponse> createWorkResponse(WorkResponse value) {
        return new JAXBElement<WorkResponse>(_WorkResponse_QNAME, WorkResponse.class, null, value);
    }

}
