package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VehicleModel {
	int year;
	String model;
	String type;
	String licensePlate;
	int lastMileage;
	Date purchaseDate;
	Date lastServiceDate;
	
	public static Date getDate(String date) {
	 	
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		 Date d = new Date();
		 
	     try { 
		     d = df.parse(date);
	      }
	     
	      catch(ParseException e) {
	         System.out.println("Unable to parse " + date);
	      }
	     
		 return d;
	 }

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getLastMileage() {
		return lastMileage;
	}

	public void setLastMileage(int lastMileage) {
		this.lastMileage = lastMileage;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
