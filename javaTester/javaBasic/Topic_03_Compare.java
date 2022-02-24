package javaBasic;

public class Topic_03_Compare {

	int number = 8;
	
	public static void main(String[] args) {
		//1 vùng nhớ cho biến x
		int x = 5;
		
		//1 vùng nhớ cho biến y
		int y = x;

		System.out.println("x = " + x );
		System.out.println("y = " + y );
		
		y = 10;
		System.out.println("x = " + x );
		System.out.println("y = " + y );
		
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;
		//Topic_03_Compare secondVariable = new Topic_03_Compare();//Nếu new lên thì tạo 2 vùng nhớ khác nhau
		
		
		System.out.println("Before = " + firstVariable.number);
		System.out.println("Before = " + secondVariable.number);
		
		secondVariable.number = 15;
		System.out.println("After = " + firstVariable.number);
		System.out.println("After = " + secondVariable.number);
		//Kiểu dữ liệu tham chiếu nên second thay đổi thì first cũng thay đổi theo (cùng 1 ô nhớ)
		//Kiểu dữ liệu nguyên thủy: 2 ô nhớ khác nhau
	}

}
