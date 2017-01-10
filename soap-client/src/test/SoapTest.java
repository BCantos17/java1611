package test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import service.BeanApi;
import service.BeanApiServiceLocator;
import soap.JavaBean;

public class SoapTest {

	public static void main(String[] args) throws ServiceException, RemoteException {
		// consume this web service
		BeanApiServiceLocator locator = new BeanApiServiceLocator();
		BeanApi exposedApi = locator.getBeanApi();
		
		JavaBean[] datas = exposedApi.getAll();
		for(JavaBean bean : datas)
			System.out.println(bean.getBeanName() + " " + bean.getAuthor());
	}
	
}








