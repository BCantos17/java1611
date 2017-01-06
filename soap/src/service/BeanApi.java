package service;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;

import soap.JavaBean;
import soap.MyApi;

// Service Implementation
@WebService
public class BeanApi {
	// just delegates all calls to an API
	private MyApi api;
	
	@WebMethod
	public void create(JavaBean bean){
		api.create(bean);
	}
	
	@WebMethod
	public JavaBean get(int id){
		return api.get(id);
	}
	
	@WebMethod
	public Collection<JavaBean> getAll(){
		return api.getAll();
	}
	
	@WebMethod
	public void delete(int id){
		api.delete(id);
	}
	
}
