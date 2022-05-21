package javaOOP.abstraction;

public abstract class Computer {
	
	//Non-abstract (Normal)
	public void showCPU() {
		System.out.println("Intel CPU");
	}
	
	//Abstract
	public abstract void setRam();
}
