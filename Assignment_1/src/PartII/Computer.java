package PartII;

//-----------------------------------------------------
//Assignment 1
//© Tejaswini Devireddy , Manimaran Palani
//Written by: Tejaswini Devireddy - 40186127
//        Manimaran Palani - 40167543
//-----------------------------------------------------

public class Computer {

	private String brand;
	private String model;
	private long sn;
	private double price;
	private static int count;
	
	
	//default constructor
	public Computer() {
		this.brand = "DefaultBrand";
		this.model = "DefaultModel";
		this.sn = 99999999;
		this.price = 99999;
		setCount();
	}
	
	//parameterized constructor
	public Computer(String brand, String model, long sn, double price)
	{
		this.brand = brand;
		this.model = model;
		this.sn = sn;
		this.price = price;
		setCount();
	}
	
	//copy constructor
	public Computer(Computer compObj) {
		this.brand = compObj.brand;
		this.model = compObj.model;
		this.sn = compObj.sn;
		this.price = compObj.price;
		setCount();
	}
	
	
	public static int getCount() {
		return count;
	}

	public static void setCount() {
		Computer.count++;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSn() {
		return sn;
	}

	public void setSn(long sn) {
		this.sn = sn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}
	
	public static int findNumberOfCreatedComputers() {
		return getCount();
	}
	
	public boolean equals(Computer compObj) {
		return compObj != null && this.getClass().equals(compObj.getClass()) 
				&& this.brand.equals(compObj.brand) && this.model == compObj.model 
				&& this.price == compObj.price;
	}
	
	public String toString()
	{
		return "Brand : "+this.brand+"\nModel : "+this.model+"\nSerial Number : "
				+this.sn+"\nPrice : "+this.price;
	}
}
