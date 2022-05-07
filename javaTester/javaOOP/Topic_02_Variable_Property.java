package javaOOP;

public class Topic_02_Variable_Property {
	static int studentNumber;
	static float studentPrice;
	static String studentCountry;
	static boolean studentStatus;
	
	//Access Modifier
	//Data Type
	//Variable name
	//Variable value
	private String studentName = "Automation FC";//Biến toàn cục (Global variable)
	
	//Static variable: Dùng và gán lại được
	public static String studentAddress = "HCM";
	
	//Dùng trong phạm vi class này (cho tất cả instance/ object dùng)
	private static String studentPhone = "095323231";
	
	//Final variable: Không cho phpes gán lại/ override lại
	final String country = "Viet Nam";
	
	//Static final variable: hằng số (constant)
	//Nó không được ghi đè
	//Có thể truy cập rộng rãi cho tất cả các íntance/ thread
	static final float PI_NUMBER = 3.1423554f;
			
	//Access Modifier: Default (chỉ truy cập trong package này)
	int StudentID = 1005;
	
	//Hàm (method) - static
	public static void main(String[] args) {
		//Local variable - biến cục bộ: hàm
		String studentName = "Automation FC";
		
		if (studentName.startsWith("Automation")) {
			//Local variable - biến cục bộ: block code
			int number = 100;
		}

		studentAddress = "Da Nang";
		studentPhone = "03844651226";
		
		//Local variable: bắt buộc phải khởi tạo mới được sử dụng
//		int studentNumber;
//		float studentPrice;
//		String studentCountry;
//		boolean studentStatus;

		System.out.println(studentNumber);
		System.out.println(studentPrice);
		System.out.println(studentCountry);
		System.out.println(studentStatus);
	}
	//Constructor
	public Topic_02_Variable_Property() {
		//Local variable - biến cục bộ: constructor
		String studentName = "Automation FC";
		
	}
	
	//Hàm (method) - non static
	public void display() {
		//Local variable - biến cục bộ: hàm
		String studentName = "Automation FC";
	}

}
