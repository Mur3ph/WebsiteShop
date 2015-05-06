package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Product;


@SuppressWarnings("rawtypes")
public class album_priceComparator implements Comparator{

	@Override
	public int compare(Object price1, Object price2) {
		// to arrange the albums in the shop in lowest price first or.....................................
		Product otherPrice1 = (Product) price1;
		Product otherPrice2 = (Product) price2;
		
		if (otherPrice1.getPrice() < otherPrice2.getPrice())
			return -1;
		if (otherPrice1.getPrice() > otherPrice2.getPrice())
			return 1;
		else
			return 0;
	}

}
