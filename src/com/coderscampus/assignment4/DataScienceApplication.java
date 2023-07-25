package com.coderscampus.assignment4;

import java.io.IOException;

public class DataScienceApplication {

	public static void main(String[] args) throws IOException {
		
		FileService fileService = new FileService();
		Student[] students = fileService.readStudentsFromCsv("student-master-list.csv");
		
		StudentManager studentManager = new StudentManager(); 
		Student[] course1Students = studentManager.separateStudentsByCourse(students, "COMPSCI");
		Student[] course2Students = studentManager.separateStudentsByCourse(students, "STAT");
		Student[] course3Students = studentManager.separateStudentsByCourse(students, "APMTH");
		
		studentManager.sortStudentsByGrade(course1Students);
		studentManager.sortStudentsByGrade(course2Students);
		studentManager.sortStudentsByGrade(course3Students);
		
		studentManager.writeStudentsToCsv(course1Students, "course1.csv");
		studentManager.writeStudentsToCsv(course2Students, "course2.csv");
		studentManager.writeStudentsToCsv(course3Students, "course3.csv");
		
		printStudentsByCourse("COMPSCI", course1Students);
		printStudentsByCourse("STAT", course2Students);
		printStudentsByCourse("APMTH", course3Students);
		

	}

	private static void printStudentsByCourse(String courseName, Student[] students) {
		System.out.println("Students enrolled in " + courseName + ":");
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

}
