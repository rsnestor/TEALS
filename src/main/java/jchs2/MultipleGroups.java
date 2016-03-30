package jchs2;

import java.util.ArrayList;
import java.util.List;

public class MultipleGroups implements NumberGroup {

	private List<NumberGroup> groupList = new ArrayList<NumberGroup>();
	
	public MultipleGroups(List<NumberGroup>groupList) {
		this.groupList = groupList;
	}
	
	@Override
	public boolean contains(int i) {
		boolean found = false;
		//Student implementation
		return found;
	}

}
