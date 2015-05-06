package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Product;

@SuppressWarnings("rawtypes")
public class album_nameComparator implements Comparator{

	@Override
	public int compare(Object name1, Object name2) {

		Product otherName1 = (Product) name1;
		Product otherName2 = (Product) name2;
		
		int comparison = otherName1.getName().compareToIgnoreCase(otherName2.getName());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
