package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentManager {

//	sorting and writing tasks
//  [ This method get's Course ] 
	public Student[] separateStudentsByCourse(Student[] students, String course) {
		try {
		Student[] courseStudents = new Student[students.length];
		Integer count = 0;
		
		for (Student student : students) {
			String courseName = student.getCourse();
			
			if (courseName.contains(course)) {
				courseStudents[count++] = student;
			}
		}
		
		System.out.println(courseStudents);
		return courseStudents;
		}catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
            // Handle the exception or take appropriate action
            return null; 			
		}
		
		
		
//		DN: System.out.println("Requested Course: " + course);
		
	
//		List<Student> courseStudents = new ArrayList<>();
//		int count = 0;
//
//
//		for (Student student : students) {
//			DN: System.out.println("Student Course: " + student.getCourse());
//			if (student != null && student.getCourse().trim().equalsIgnoreCase(course)) {
//				courseStudents.add(student);
//			}
//		}
//		System.out.println("Course: " + course + ", count: " + courseStudents.size());
//		System.out.println("Course: " + course + ", courseStudents: " + courseStudents);
		

		
		

		// ML: COMMENTED OUT
//		Student[] courseStudents = new Student[count];
//		int index = 0;
//
//		for (Student student : students) {
//			if (student != null && student.getCourse().trim().equalsIgnoreCase(course)) {
//				courseStudents[index++] = student;

	
//		return courseStudents.toArray(new Student[0]);
		
		
	}

	// Want 3 different arrays by Grade
//  [ This method get's Grade ]
	public void sortStudentsByGrade(Student[] students) {
		Student[] courseGrades = new Student[students.length];
		int count = 0;
		
		for (Student student : students) {
			Integer studentGrade = student.getGrade();

			System.out.println(studentGrade);
		}
		
		
		
		Student[] compsciStudents = separateStudentsByCourse(students, "COMPSCI");
		Student[] statStudents = separateStudentsByCourse(students, "STAT");
		Student[] apmthStudents = separateStudentsByCourse(students, "APMTH");

		Arrays.sort(compsciStudents);
		Arrays.sort(statStudents);
		Arrays.sort(apmthStudents);

		
	}

	public void writeStudentsToCsv(Student[] students, String fileName) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("StudentID, Student Name, Course, Grade\n");
//			System.out.println(Arrays.toString(students));
			for (Student student : students) {
				if (student != null) {
					Integer studentID = student.getStudentID();
					String studentName = student.getStudentName();
					String course = student.getCourse();
					Integer grade = student.getGrade();

					String line = studentID + "," + studentName + "," + course + "," + grade + "\n";
					System.out.println("Writing line: " + line);
					writer.write(line);
//				System.out.println(Arrays.toString(students));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}