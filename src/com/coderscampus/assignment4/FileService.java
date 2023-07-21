package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

	public Student[] readStudentsFromCsv(String filName) throws IOException {
		Student[] students = new Student[100];

		try (FileInputStream fileInput = new FileInputStream("student-master-list.csv"); //try with resources
				InputStreamReader inputReader = new InputStreamReader(fileInput);
				BufferedReader reader = new BufferedReader(inputReader);) {

			reader.readLine(); // skip header line in master csv list

			String line;
			int index = 0; // index for # of students read
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 4) {
					int studentID = Integer.parseInt(data[0]);
					String studentName = data[1];
					String course = data[2];
					int grade = Integer.parseInt(data[3]);

					Student student = new Student(studentID, studentName, course, grade);

//				add students to the array at the current index
					students[index] = student;
					index++;
				}
			}
//		resize the array to actual number of students read and copy elements manually
			Student[] trimmedStudents = new Student[index];
			for (int i = 0; i < index; i++) {
				trimmedStudents[i] = students[i];
			}
			students = trimmedStudents;

		}

		return students;
	}
}
