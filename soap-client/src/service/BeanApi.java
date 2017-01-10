/**
 * BeanApi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface BeanApi extends java.rmi.Remote {
    public soap.JavaBean get(int id) throws java.rmi.RemoteException;
    public void delete(int id) throws java.rmi.RemoteException;
    public void create(soap.JavaBean bean) throws java.rmi.RemoteException;
    public soap.JavaBean[] getAll() throws java.rmi.RemoteException;
}
