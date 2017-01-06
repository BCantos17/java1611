package soap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyApi {

	private static Map<Integer, JavaBean> database = 
			new HashMap<Integer, JavaBean>();
	
	// CRUD methods
	public void create(JavaBean bean){
		database.put(bean.getId(), bean);
	}
	
	public JavaBean get(int id){
		return database.get(id);
	}
	
	public Collection<JavaBean> getAll(){
		return database.values();
	}
	
	public void delete(int id){
		database.remove(id);
	}
	
}








