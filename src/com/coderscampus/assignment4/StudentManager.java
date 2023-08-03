package com.coderscampus.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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
			Arrays.sort(exactStudentsByCourse);
			return exactStudentsByCourse;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());

			return null;
		}

	}

	public void writeStudentsToCsv(Student[] students, String fileName) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write("StudentID, Student Name, Course, Grade\n");
			for (Student student : students) {
				if (student != null) {
					Integer studentID = student.getStudentID();
					String studentName = student.getStudentName();
					String course = student.getCourse();
					Integer grade = student.getGrade();

					String line = studentID + "," + studentName + "," + course + "," + grade + "\n";
					writer.write(line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}