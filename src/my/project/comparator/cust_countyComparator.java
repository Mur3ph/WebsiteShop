package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Customer;

@SuppressWarnings("rawtypes")
public class cust_countyComparator implements Comparator{

	@Override
	public int compare(Object county1, Object county2) {
		
		Customer otherCounty1 = (Customer) county1;
		Customer otherCounty2 = (Customer) county2;
		
		int comparison = otherCounty1.getCounty().compareToIgnoreCase(otherCounty2.getCounty());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
