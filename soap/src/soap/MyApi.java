package soap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyApi {

	private static Map<Integer, JavaBean> database = 
			new HashMap<Integer, JavaBean>();
	
	// CRUD methods
	public void create(JavaBean bean){
		System.out.println("CREATE: " + bean);
		database.put(bean.getId(), bean);
	}
	
	public JavaBean get(int id){
		System.out.println("GET: " + id);
		return database.get(id);
	}
	
	public Collection<JavaBean> getAll(){
		System.out.println("GET ALL");
		return database.values();
	}
	
	public void delete(int id){
		System.out.println("DELETE: " + id);
		database.remove(id);
	}
	
}








