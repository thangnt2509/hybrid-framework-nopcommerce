package javaBasic;

import java.util.Iterator;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;	
		//number += 5;
		//number = number + 5;		
		System.out.println(number);
		
		//15/5 = 3
		System.out.println(number/5);
		
		//15%7 = 2 dư 1
		System.out.println(number%7);
		
		System.out.println(number++);
		//In number ra trước: 10
		//++ = tăng number lên 1 = 11
		
		System.out.println(++number);
		//++ trước: tăng number lên 1: 12
		//In number ra: 12
		
		System.out.println(--number);
		System.out.println(number--);

		for (int i = 0; i <= 3; i++) {
			System.out.println(i);
		}	
	}

}
