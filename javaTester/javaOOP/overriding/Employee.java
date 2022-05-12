package javaOOP.overriding;

public class Employee extends Person implements IWork{
	@Override
	public void eat() {
		System.out.println("Suất cơm 25.000 VND");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 7h/ ngày");
		
	}

	@Override
	public void workingTime() {
		System.out.println("Học 6h/ ngày");
		
	}
}
