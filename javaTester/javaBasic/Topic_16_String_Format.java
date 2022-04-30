package javaBasic;

public class Topic_16_String_Format {

	public static void main(String[] args) {
		String text = String.format("xpath=//div[@class='listbox']//a[text()='%s']", "Reward points");
		System.out.println(text);
	}

}
