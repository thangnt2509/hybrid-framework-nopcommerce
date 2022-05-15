package javaOOP.inheritance;

import java.util.Objects;

public class Test extends Annimal {

	public static void main(String[] args) {
//		HuskyDog dog = new HuskyDog();
//		dog.run();
//		dog.eat();
//		dog.hunt();
		
		//Mặc định 1 class đang kế thừa class Object
		//Nếu class Test kế thừa tiếp Annimal thì chuyển thành kế thừa nhiều cấp: 
		//Test kế thừa Annimal, Annimal kế thừa Object chứ không phải Test đang vừa kế thừa Annimal và Object
		Test test = new Test();
		System.out.println(test.toString());
		
		Object _object;
		
		Dog dog = new Dog();
		dog.setAge(-15);
		System.out.println(dog.getAge());
		
		dog.setAge(5);
		System.out.println(dog.getAge());
		}
	
	@Override
	public String toString() {
		return "This is a Testing class ";
	}
	

}
