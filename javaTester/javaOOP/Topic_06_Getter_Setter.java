package javaOOP;

import lombok.Getter;
import lombok.Setter;


public class Topic_06_Getter_Setter {// mục đích để bảo vệ dữ liệu, biến nên để private
	// Không kiểm tra/ validate dữ liệu được
	@Getter
	@Setter
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;
	

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty() || personName.isBlank()) {
			throw new IllegalArgumentException("Tên nhập vào không được bỏ trống");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		if (personAge > 15 && personAge < 76) {
			throw new IllegalArgumentException("Tuổi nhập vào không hợp lệ");
		} else {
			this.personAge = personAge;
		}
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải từ 10-11 số.");
		} else {
			this.personPhone = personPhone;
		}
	}

	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}

//	// Setter
//	public void setPersonName(String personName) {
//		if (personName == null || personName.isEmpty() || personName.isBlank()) {
//			throw new IllegalArgumentException("Tên nhập vào không hợp lệ");
//		} else {
//			this.personName = personName;
//		}
//	}
//
//	// Getter
//	public String getPersonName() {
//		return this.personName;
//	}

}
