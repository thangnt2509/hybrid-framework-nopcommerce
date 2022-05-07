package javaOOP;

public class Topic_01_Class_Object_Student {
	public int studentID; //Instance variable
	private String studentName;
	private Float knowledgePoint;
	private Float practicePoint;
	
	private int getStudentID() {
		return studentID;
	}


	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	private String getStudentName() {
		return studentName;
	}


	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	private Float getKnowledgePoint() {
		return knowledgePoint;
	}


	private void setKnowledgePoint(Float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}


	private Float getPracticePoint() {
		return practicePoint;
	}


	private void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowledgePoint + this.practicePoint * 2) / 3;
	}
	private void showStudentInfo() {
		System.out.println("*********************************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());
		System.out.println("Student knowledge Point = " + getKnowledgePoint());
		System.out.println("Student practice Point = " + getPracticePoint());
		System.out.println("Student average Point = " + getAveragePoint());
		System.out.println("*********************************");
	}
	
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(1);
		firstStudent.setStudentName("Minh Anh");
		firstStudent.setKnowledgePoint(7.5f);
		firstStudent.setPracticePoint(6.0f);
		firstStudent.showStudentInfo();
		
		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		secondStudent.setStudentID(1);
		secondStudent.setStudentName("Minh Anh");
		secondStudent.setKnowledgePoint(5.8f);
		secondStudent.setPracticePoint(7.4f);
		secondStudent.showStudentInfo();
	}

}
