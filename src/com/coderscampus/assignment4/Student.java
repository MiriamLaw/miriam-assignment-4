package com.coderscampus.assignment4;

public class Student implements Comparable<Student> {

	int studentID;
	String studentName;
	String course;
	int grade;

	public Student(int studentID, String studentName, String course, int grade) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;

	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", course=" + course + ", grade="
				+ grade + "]";
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student that) {

		return Integer.compare(this.getGrade(), that.getGrade());

	}

}
