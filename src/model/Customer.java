package model;

import java.util.Scanner;

public class Customer {
	private
		int customerId;
		String name;
		int phoneNumber;
		String address;
		
		public int getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getPhoneNumber() {
			return phoneNumber;
		}
		
		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
}
