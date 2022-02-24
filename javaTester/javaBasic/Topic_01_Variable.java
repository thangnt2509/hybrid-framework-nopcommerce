package javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {

	public Topic_01_Variable() {// Hàm khởi tạo ko có kiểu trả về, phải cùng tên với tên class
		String studentName;
	}

	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome";// constant: hằng số

	static int studentPrice;

	String studentName = "Automation FE";

	public static void main(String[] args) {
		int studentPrice = 5;

		System.out.println(studentNumber);
		System.out.println(statusValue);

		System.out.println(studentPrice);
		System.out.println(Topic_01_Variable.BROWSER_NAME);
		System.out.println(Topic_01_Variable.statusValue);
		System.out.println(Topic_01_Variable.studentPrice);

		Topic_01_Variable topic_1 = new Topic_01_Variable();
		Topic_01_Variable topic_2 = new Topic_01_Variable();
		Topic_01_Variable topic_3 = new Topic_01_Variable();

		System.out.println(topic_1.studentName);
		System.out.println(topic_2.studentName);
		System.out.println(topic_3.studentName);
		
		Scanner scaner = new Scanner(System.in);
		String name = scaner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);

	}

	// Getter: getCurrentUrl/ getTitle/ getText, getAttribute...
	public String getStudentNumber() {
		return this.studentName;

	}

	// Setter: click/ sendkey/ clear/ select/ back/ forward/ refresh/ get...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}

}
