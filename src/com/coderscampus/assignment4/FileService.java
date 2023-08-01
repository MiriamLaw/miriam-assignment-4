package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

	public Student[] readStudentsFromCsv(String fileName) throws IOException {

		Student[] students = new Student[100];
		int studentCount = 0;

		try (FileInputStream fileInput = new FileInputStream(fileName); // try with resources
				InputStreamReader inputReader = new InputStreamReader(fileInput);
				BufferedReader reader = new BufferedReader(inputReader);) {

			reader.readLine(); // skip header line in master csv list
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Integer studentID = Integer.parseInt(data[0]);
				String studentName = data[1];
				String course = data[2];
				Integer grade = Integer.parseInt(data[3]);

				Student student = new Student(studentID, studentName, course, grade);
				students[studentCount] = student;
				studentCount++;

			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return students;

	}
}