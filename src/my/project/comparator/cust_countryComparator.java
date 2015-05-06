package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Customer;

@SuppressWarnings("rawtypes")
public class cust_countryComparator implements Comparator{

	@Override
	public int compare(Object country1, Object country2) {

		Customer otherCountry1 = (Customer) country1;
		Customer otherCountry2 = (Customer) country2;
		
		int comparison = otherCountry1.getCountry().compareToIgnoreCase(otherCountry2.getCountry());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
