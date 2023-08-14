package com.coderscampus.assignment4;

import java.io.IOException;

public class StudentManager {

	public Student[] separateStudentsByCourse(Student[] students, String course) {
		try {
			Student[] courseStudents = new Student[students.length];
			Integer count = 0;

			for (Student student : students) {
				String courseName = student.getCourse();
				if (courseName.contains(course)) {
					courseStudents[count] = student;
					count++;
				} else {
					continue;
				}
			}
			int myCounts = 0;

			for (Student student : courseStudents) {
				if (student != null)
					myCounts++;
			}
			Student[] exactStudentsByCourse = new Student[myCounts];

			int index = 0;
			for (Student student : courseStudents) {
				if (student != null) {
					exactStudentsByCourse[index] = student;
					index++;
				}
			}
			return exactStudentsByCourse;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());

			return null;
		}

	}

	public void exportCourseStudentsReportAsCSV(Student[] students, String courseKey, String exportFilename)
			throws IOException {
		Student[] courseStudents = separateStudentsByCourse(students, courseKey);

		FileService fileService = new FileService();
		fileService.writeStudentsToCsv(courseStudents, exportFilename);
	}

}