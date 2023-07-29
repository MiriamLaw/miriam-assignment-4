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
//			for (Student student : students) {
//				if (student != null) {
//					// DN: PRINTS ALL THE DATA OF EACH STUDENT FIRST BEFORE ANY OTHER SYSOUT.
//					// we added these two lines to have console printout
////					System.out.println(student); 
//				}
//			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

// 		This is not the area where you want to limit the data you pass on.
// 		Allow the whole Student object through and grab what you need within the StudentManager.java file
		
//		return Arrays.copyOf(students, studentCount);
//		DN: System.out.println(students);
		return students;

	}
}