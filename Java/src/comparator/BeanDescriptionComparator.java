package comparator;

import java.util.Comparator;

public class BeanDescriptionComparator implements Comparator<Bean>{

	@Override
	public int compare(Bean o1, Bean o2) {
		return o1.getDescription()
				.compareTo(o2.getDescription());
	}

}
