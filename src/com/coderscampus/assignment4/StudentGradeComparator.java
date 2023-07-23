package com.coderscampus.assignment4;

import java.util.Comparator;

public class StudentGradeComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		if (student1 == null && student2 == null) {
			return 0;
			
		}
		if (student1 == null) {
			return 1;
		}
		if (student2 == null) {
			return -1;
		}
		return Integer.compare(student2.getGrade(), student1.getGrade());
	}

}
