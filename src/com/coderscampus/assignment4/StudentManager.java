package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentManager {
	
//	sorting and writing tasks
	
	public Student[] separateStudentsByCourse(Student[] students, String course) {
				
		int count = 0; 
		
		for (Student student : students) {
			if (student != null && student.getCourse().trim().equalsIgnoreCase(course)) {
				count++;
				System.out.println(Arrays.toString(students));
			}
		}
		
		Student[] courseStudents = new Student[count];
		int index = 0;
		
		for (Student student : students) {
			if (student != null && student.getCourse().trim().equalsIgnoreCase(course)) {
				courseStudents[index++] = student;
			}
		}
		return courseStudents;
	}
	
	public void sortStudentsByGrade(Student[] students) {
//		System.out.println(Arrays.toString(students));
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));		
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
//				System.out.println(Arrays.toString(students));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
