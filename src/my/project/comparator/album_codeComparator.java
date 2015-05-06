package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Product;

@SuppressWarnings("rawtypes")
public class album_codeComparator implements Comparator{

	@Override
	public int compare(Object code1, Object code2) {

		Product otherCode1 = (Product) code1;
		Product otherCode2 = (Product) code2;
		
		int comparison = otherCode1.getCode().compareToIgnoreCase(otherCode2.getCode());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
