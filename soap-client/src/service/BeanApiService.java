/**
 * BeanApiService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface BeanApiService extends javax.xml.rpc.Service {
    public java.lang.String getBeanApiAddress();

    public service.BeanApi getBeanApi() throws javax.xml.rpc.ServiceException;

    public service.BeanApi getBeanApi(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
