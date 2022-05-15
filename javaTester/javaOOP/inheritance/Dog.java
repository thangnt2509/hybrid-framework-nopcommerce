package javaOOP.inheritance;

public class Dog extends Annimal implements Runable{
//	public Dog() {
//		super("Tom", "5");
//		System.out.println("Child's constructor");
//	}
	private int age;
	
	public void run() {
		System.out.println("Running...");
	}
	
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}else {
			this.age = 0;
		}
	}
	
	public int getAge() {
		return this.age;
	}
}
