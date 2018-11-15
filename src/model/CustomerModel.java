package model;

import java.util.Scanner;

public class CustomerModel {
	private
		String customerId;
		String name;
		int phoneNumber;
		String address;
		String password;
		
		
		public CustomerModel(String customerId){
			
		}
		
		public static void viewProfile() {
			String query = "SELECT customerId, name, address, email, phoneNmuber, licensePlate FROM Customer c, Owns o WHERE c.customerId="+ + "c.customerId=o.customerId";
		}
		
		public String getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(String customerId) {
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
