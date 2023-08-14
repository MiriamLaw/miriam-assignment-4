package com.coderscampus.assignment4;

import java.io.IOException;
import java.util.Arrays;

public class DataScienceApplication {

	public static void main(String[] args) throws IOException {

		FileService fileService = new FileService();
		Student[] students = fileService.readStudentsFromCsv("student-master-list.csv");
		Arrays.sort(students);

		StudentManager studentManager = new StudentManager();

		studentManager.exportCourseStudentsReportAsCSV(students, "COMPSCI", "course1.csv");
		studentManager.exportCourseStudentsReportAsCSV(students, "STAT", "course2.csv");
		studentManager.exportCourseStudentsReportAsCSV(students, "APMTH", "course3.csv");
	}
}
