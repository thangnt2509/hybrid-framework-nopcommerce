package javaBasic;

public class Topic_11_Ex7_Student {
	int stdID;
	String stdName;
	int stdAge;
	double stdScore;

	public Student(int stdID, String stdName, int stdAge, double stdScore) {
		this.stdID = stdID;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdScore = stdScore;
	}

	public void display() {
		System.out.println("Student ID: " + stdID);
		System.out.println("Student Name: " + stdName);
		System.out.println("Student Age: " + stdAge);
		System.out.println("Student Score: " + stdScore);
	}

	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student(001, "Tuan", 24, 8.0);
		students[1] = new Student(002, "Hong", 25, 6.0);
		students[2] = new Student(003, "Lan", 20, 87.5);
	}
}
