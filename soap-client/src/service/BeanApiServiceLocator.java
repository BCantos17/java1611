/**
 * BeanApiServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class BeanApiServiceLocator extends org.apache.axis.client.Service implements service.BeanApiService {

    public BeanApiServiceLocator() {
    }


    public BeanApiServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BeanApiServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BeanApi
    private java.lang.String BeanApi_address = "http://10.255.184.244:7001/soap/services/BeanApi";

    public java.lang.String getBeanApiAddress() {
        return BeanApi_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BeanApiWSDDServiceName = "BeanApi";

    public java.lang.String getBeanApiWSDDServiceName() {
        return BeanApiWSDDServiceName;
    }

    public void setBeanApiWSDDServiceName(java.lang.String name) {
        BeanApiWSDDServiceName = name;
    }

    public service.BeanApi getBeanApi() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BeanApi_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBeanApi(endpoint);
    }

    public service.BeanApi getBeanApi(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.BeanApiSoapBindingStub _stub = new service.BeanApiSoapBindingStub(portAddress, this);
            _stub.setPortName(getBeanApiWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBeanApiEndpointAddress(java.lang.String address) {
        BeanApi_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.BeanApi.class.isAssignableFrom(serviceEndpointInterface)) {
                service.BeanApiSoapBindingStub _stub = new service.BeanApiSoapBindingStub(new java.net.URL(BeanApi_address), this);
                _stub.setPortName(getBeanApiWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BeanApi".equals(inputPortName)) {
            return getBeanApi();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service", "BeanApiService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service", "BeanApi"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BeanApi".equals(portName)) {
            setBeanApiEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
