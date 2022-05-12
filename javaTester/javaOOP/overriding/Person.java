package javaOOP.overriding;

public abstract class Person {
	//Option
	public void eat() {
		System.out.println("Suất cơm 20.000 VND");
	}
	
	//Must (template)
	public abstract void sleep();
	
	//Class con không override final được
	public final void walk() {
		System.out.println("Đi bộ");
	}
	
	//Class con không override static được
	public static void run() {
		System.out.println("Chạy");
	}
	
	//Private không được phép override
	private void dating() {
		System.out.println("Hẹn hò");
	}

}
