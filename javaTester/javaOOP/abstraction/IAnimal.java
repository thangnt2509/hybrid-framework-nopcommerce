package javaOOP.abstraction;

public interface IAnimal {
	//Interface xem tất cả method là abstract method
	//Tất cả đều là public dù chỉ rõ hay không
	//Không có các access modifier khác như private, protected..
	String getName();
	
	void setName(String name);
	
	abstract String getAddress();
	
	public abstract void setAdress(String address);
	
	//coi tất cả các biến là hằng số (public static final) dù có chỉ rõ hay không
	int SUM_NUMBER = 100;
	//Toàn bộ là public và abstract hết
}
