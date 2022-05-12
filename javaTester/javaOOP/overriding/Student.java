package javaOOP.overriding;

public class Student extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Suất cơm 15.000 VND");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 9h/ ngày");
		
	}

	@Override
	public void workingTime() {
		System.out.println("Làm 8h/ ngày");
		
	}
	
}
