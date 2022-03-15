package javaBasic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

	public static void main(String[] args) {
		int number[] = { 1, 8, 4, 6, 9 };
		int[] student = { 1, 8, 4, 6, 9 };

		// Lấy ra phần tử đầu tiên
		System.out.println(student[0]);
		System.out.println(student[1]);

		// System.out.println(student[6]);

		// Cố định
		// Được define cố định bao nhiêu phần tử khi mình viết code (Compile)
		String studentName[] = { "Nam", "Long", "An" };
		studentName[0] = "Hoa";

		String stdNewName[] = studentName.clone();

		int b[] = new int[5];
		b[0] = 0;

		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Long")) {
				System.out.println("Click vào Long");

			}
		}

		// Foreach không kết hợp được với index. Muốn thì phải thêm biến i
		for (String std : studentName) {
			if (std.equals("Long")) {
				System.out.println("Click click");
			}
		}

		// Động
		ArrayList<String> stdName = new ArrayList<>();

		// Khi chạy code mới add (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}

		// Chuyển từ array qua list
		List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
		for (String name : names) {
			System.out.println("Name: " + name);
		}

		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);

	}

}
