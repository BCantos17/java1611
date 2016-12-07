package comparator;

import java.util.Comparator;

public class BeanVariableComparator implements Comparator<Bean> {

	@Override
	public int compare(Bean o1, Bean o2) {
		return o1.getVariable()
				.compareTo(o2.getVariable());
	}
	
}
