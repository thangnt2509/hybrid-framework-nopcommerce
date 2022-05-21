package javaOOP.polymorphism;

public class Operator {
	public void sum(int a, int b) {
		System.out.println(a + b);
	}
	public void sum(double a, double b) {
		System.out.println(a + b);
	}
	public void sum(float a, float b) {
		System.out.println(a + b);
	}
	public void sum(long a, long b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		Operator opr = new Operator();
		
		//Trình biên dịch nó sẽ tự chọn phương thức nào
		opr.sum(5, 8);
		opr.sum(5000l, 5000l);
		opr.sum(5.18d, 9.15d);
		opr.sum(5.18f, 9.15f);

	}

}
