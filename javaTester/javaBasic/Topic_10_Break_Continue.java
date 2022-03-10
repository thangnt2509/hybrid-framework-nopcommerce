package javaBasic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			// Loại trừ 1 điều kiện này ra
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

	}

}
