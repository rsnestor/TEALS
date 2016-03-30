package jchs2;

import java.util.Arrays;
import java.util.List;

public class Marcus implements Teacher, Student {

	@Override
	public String getName() {
		return "Marcus";
	}

	@Override
	public int getWeight() {
		return 225;
	}

	@Override
	public String getHairColor() {
		return "Brown";
	}

	@Override
	public int getAge() {
		return 18;
	}

	@Override
	public double getGPA() {
		return 3.5;
	}

	@Override
	public String getSchool() {
		return "John Champe";
	}

	@Override
	public List<String> getPrimarySubjects() {
		String[] subs = {"Algebra","Geometry","Calculus"};
		return Arrays.asList(subs);
	}

}
