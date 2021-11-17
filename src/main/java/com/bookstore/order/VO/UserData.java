package com.bookstore.order.VO;

public class UserData {
	private String email;
	private String address;
	@Override
	public String toString() {
		return "UserData [email=" + email + ", address=" + address + "]";
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
