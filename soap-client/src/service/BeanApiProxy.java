package service;

public class BeanApiProxy implements service.BeanApi {
  private String _endpoint = null;
  private service.BeanApi beanApi = null;
  
  public BeanApiProxy() {
    _initBeanApiProxy();
  }
  
  public BeanApiProxy(String endpoint) {
    _endpoint = endpoint;
    _initBeanApiProxy();
  }
  
  private void _initBeanApiProxy() {
    try {
      beanApi = (new service.BeanApiServiceLocator()).getBeanApi();
      if (beanApi != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)beanApi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)beanApi)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (beanApi != null)
      ((javax.xml.rpc.Stub)beanApi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.BeanApi getBeanApi() {
    if (beanApi == null)
      _initBeanApiProxy();
    return beanApi;
  }
  
  public soap.JavaBean get(int id) throws java.rmi.RemoteException{
    if (beanApi == null)
      _initBeanApiProxy();
    return beanApi.get(id);
  }
  
  public void delete(int id) throws java.rmi.RemoteException{
    if (beanApi == null)
      _initBeanApiProxy();
    beanApi.delete(id);
  }
  
  public void create(soap.JavaBean bean) throws java.rmi.RemoteException{
    if (beanApi == null)
      _initBeanApiProxy();
    beanApi.create(bean);
  }
  
  public soap.JavaBean[] getAll() throws java.rmi.RemoteException{
    if (beanApi == null)
      _initBeanApiProxy();
    return beanApi.getAll();
  }
  
  
}