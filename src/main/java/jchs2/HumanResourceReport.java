package jchs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanResourceReport {

	public static void main(String[] args) {
		HumanResourceReport rpt = new HumanResourceReport();
		Teacher mark = new Marcus();
		Student sri = new Sri();
		Person scott = new Scott();
		System.out.printf("%s is %s\n",mark.getName(),(rpt.isOld(mark)?"old":"young"));
		System.out.printf("%s is %s\n",sri.getName(),(rpt.isOld(sri)?"old":"young"));
		System.out.printf("%s is %s\n",scott.getName(),(rpt.isOld(scott)?"old":"young"));
		System.out.printf("%s is %s\n",sri.getName(),(rpt.hasMoreFun(sri)?"fun":"boring"));
		//cast Teacher to Student
		System.out.printf("%s is %s\n",mark.getName(),(rpt.hasMoreFun((Student)mark)?"fun":"boring"));
		System.out.printf("%s is %s\n",mark.getName(),(rpt.isStressedOut(mark)?"stressed":"relaxed"));
		System.out.printf("%s loves %s\n",mark.getName(),(rpt.isLifelongLearner(mark)?"reading":"youtube"));
	}
	
	public boolean isOld(Person p) {
		return p.getAge() > 40;
	}
	
	public boolean hasMoreFun(Student s) {
		return s.getHairColor().equalsIgnoreCase("blonde") && s.getGPA() < 4.0;
	}
	
	public boolean isStressedOut(Teacher t) {
		return t.getPrimarySubjects().size()>2 && t instanceof Student;
	}
	
	public boolean isLifelongLearner(Teacher t) {
		return t instanceof Student;
	}

}
