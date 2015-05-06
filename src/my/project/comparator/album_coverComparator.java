package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Product;

@SuppressWarnings("rawtypes")
public class album_coverComparator implements Comparator{

	@Override
	public int compare(Object cover1, Object cover2) {
		
		
		Product otherCover1 = (Product) cover1;
		Product otherCover2 = (Product) cover2;
		
		int comparison = otherCover1.getCover().compareToIgnoreCase(otherCover2.getCover());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;

		
	}

}
