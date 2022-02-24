package javaBasic;

public class Topic_02_Data_Type {
	// Global variable
	static int number;//Khai báo ngoài hàm nên cần thêm static

	String address = "Ho Chi Minh";
	public static void main(String[] args) {
		// Local variable
		int studentNumber = 0;
		
		System.out.println(number);
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		System.out.println(topic.address);
		
		System.out.println(studentNumber);
	}
}
