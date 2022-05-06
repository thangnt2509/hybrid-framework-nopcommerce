package javaOOP;

public class Student {
	private int studentID;
	private String studenName;
	private float theoryPoint;
	private float practicePoint;
	

	protected Student(int studentID, String studenName, float theoryPoint, float practicePoint) {
		super();
		this.studentID = studentID;
		this.studenName = studenName;
		this.theoryPoint = theoryPoint;
		this.practicePoint = practicePoint;
	}

	protected int getStudentID() {
		return studentID;
	}

	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	protected String getStudenName() {
		return studenName;
	}

	protected void setStudenName(String studenName) {
		this.studenName = studenName;
	}

	protected float getTheoryPoint() {
		return theoryPoint;
	}

	protected void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	protected float getPracticePoint() {
		return practicePoint;
	}

	protected void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	public float caculateAveragePoint() {
		float avaragePoint = (this.getTheoryPoint() + this.getPracticePoint() * 2) / 3;
		return avaragePoint;
	}
	protected void showStudentInfo() {
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student name = " + getStudenName());
		System.out.println("Student average point = " + caculateAveragePoint());
	}
	
	public static void main(String[] args) {
		Student studentA = new Student(1, "Minh Anh", 7.5f, 5f);
		Student studentB = new Student(2, "Thuy Trang", 8.75f, 6.5f);
		Student studentC = new Student(3, "Thuy Duong", 6.25f, 7f);
		
		studentA.showStudentInfo();
		studentB.showStudentInfo();
		studentC.showStudentInfo();
	}
}
