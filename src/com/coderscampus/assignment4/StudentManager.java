package com.coderscampus.assignment4;

public class StudentManager {
	
//	sorting and writing tasks
	
	public Student[] separateStudentsByCourse(Student[] students, String course) {
		
		Student[] courseStudents = new Student[students.length];
		
		int index = 0;
		
		for (Student student : students) {
			if (student.getCourse().equals(course)) {
				courseStudents[index] = student;
				index++;
			}
		}
		
		Student[] trimmedCourseStudents = new Student[index];
		for (int i = 0; i < index; i++) {
			trimmedCourseStudents[i] = courseStudents[i];
		}
		return trimmedCourseStudents;
	}
	
	public void sortStudentsByGrade(Student[] students) {
		
	}
	
	public void writeStudentsToCsv(Student[] students, String fileName) {
		
	}

}
