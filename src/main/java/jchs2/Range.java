package jchs2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the NumberGroup interface
**/
public class Range implements NumberGroup {
	
	List <Integer>intList = new ArrayList<Integer>();
	
	public Range(Collection<? extends Integer> i) {
		//Constructor 1 - fill intList
	}
	
	public Range(int min, int max){
		//Constructor 2 - fill intList
	}

	@Override
	public boolean contains(int i) {
		return intList.contains(new Integer(i));
	}

};
