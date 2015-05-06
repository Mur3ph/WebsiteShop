package my.project.comparator;

import java.util.Comparator;

import my.project.business_classes.Customer;

@SuppressWarnings("rawtypes")
public class cust_fnameComparator implements Comparator{

	@Override
	public int compare(Object name1, Object name2) {

		Customer otherName1 = (Customer) name1;
		Customer otherName2 = (Customer) name2;
		
		int comparison = otherName1.getFirstName().compareToIgnoreCase(otherName2.getFirstName());
		
		if (comparison < 0)
			return -1;
		if (comparison > 0)
			return 1;
		else
			return 0;
		
	}

}
