package javaOOP.overriding;

public class Testing {

	public static void main(String[] args) {
		//Hàm abstract không cần new
//		Person p = new Person();
//		p.eat();

		Student s = new Student();
		s.eat();
		s.sleep();
		
		Employee e = new Employee();
		e.eat();
		e.sleep();
	}

}
