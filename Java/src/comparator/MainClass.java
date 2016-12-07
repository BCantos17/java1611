package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List <Bean> beanBag = new ArrayList<Bean>();
		beanBag.add(new Bean(1, "a", "aaa"));
		beanBag.add(new Bean(3, "b", "dca"));
		beanBag.add(new Bean(2, "c", "cca"));
		
		Collections.sort(beanBag, new BeanDescriptionComparator());
		
	}
	
}
