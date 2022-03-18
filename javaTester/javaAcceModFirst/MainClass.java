package javaAcceModFirst;

public class MainClass {

	public static void main(String[] args) {
		Student std = new Student();

		// Happy path case
		std.setAge(15);
		System.out.println(std.getAge());

		// Unhappy path case
		std.setAge(-15);
		System.out.println(std.getAge());

	}

}
