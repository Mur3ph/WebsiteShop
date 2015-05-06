package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Product;

@SuppressWarnings("rawtypes")
public class album_genreComparator implements Comparator{

	@Override
	public int compare(Object genre1, Object genre2) {

		Product otherGenre1 = (Product) genre1;
		Product otherGenre2 = (Product) genre2;
		
		int comparison = otherGenre1.getGenre().compareToIgnoreCase(otherGenre2.getGenre());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
