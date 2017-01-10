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
	private MyApi api = new MyApi();
	
	@WebMethod
	public void create(JavaBean bean){
		api.create(bean);
	}
	
	@WebMethod
	public JavaBean get(int id){
		return api.get(id);
	}
	
	@WebMethod
	public JavaBean[] getAll(){
		return api.getAll().toArray(new JavaBean[0]);
	}
	
	@WebMethod
	public void delete(int id){
		api.delete(id);
	}
	
}
