package javaOOP;

public interface IComputer {
	//Interface không chứa hàm không phải abtract
	//Nếu không gán từ khóa là abstract cho hàm thì tự hiểu đay vẫn là 1 hàm abstract
	public void showComputerPerformance();
	
	//Abstract method
	public abstract void showComputerRam();
}
