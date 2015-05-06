package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Customer;

@SuppressWarnings("rawtypes")
public class cust_cityComparator implements Comparator{

	@Override
	public int compare(Object city1, Object city2) {

		Customer otherCity1 = (Customer) city1;
		Customer otherCity2 = (Customer) city2;
		
		int comparison = otherCity1.getCity().compareToIgnoreCase(otherCity2.getCity());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
