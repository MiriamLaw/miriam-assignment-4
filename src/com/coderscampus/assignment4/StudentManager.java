package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentManager {
	
//	sorting and writing tasks
	
	public Student[] separateStudentsByCourse(Student[] students, String course) {
		
		Student[] courseStudents = new Student[students.length];
		
		int index = 0;
		
		for (Student student : students) {
			if (student.getCourse().equals(course)) {
				courseStudents[index] = student;
				index++;
//				System.out.println(Arrays.toString(courseStudents));
			}
		}
		
		Student[] trimmedCourseStudents = new Student[index];
		for (int i = 0; i < index; i++) {
			trimmedCourseStudents[i] = courseStudents[i];
		}
		return trimmedCourseStudents;
	}
	
	public void sortStudentsByGrade(Student[] students) {
//		System.out.println(Arrays.toString(students));
		Arrays.sort(students, new StudentGradeComparator());
//		System.out.println(Arrays.toString(students));		
		}
	
	public void writeStudentsToCsv(Student[] students, String fileName) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("StudentID, Student Name, Course, Grade\n");
//			System.out.println(Arrays.toString(students));
			for (Student student : students) {
				int studentID = student.getStudentID();
				String studentName = student.getStudentName();
				String course = student.getCourse();
				int grade = student.getGrade();
						
				String line = studentID + "," + studentName + "," + course + "," + grade + "\n"; 	
				writer.write(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
