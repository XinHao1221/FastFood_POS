
//This module handled by: Koh Xin Hao

import java.io.Serializable;

public class Product implements Serializable{
	
	private String productName;
	private String productDescription;
	private double productPrice;
	private int orderedTimes;
	public static int typeOfProduct = 0;
	
		
    public Product(String productName, String productDescription, double productPrice) {
    	this.productName = productName;
    	this.productDescription = productDescription;
    	this.productPrice = productPrice;
    	orderedTimes = 0;
    	typeOfProduct++;
    }
    
   	public Product(){
   		productName = "";
   		productDescription = "";
   		productPrice = 0;
   		orderedTimes = 0;
   		typeOfProduct++;
   	}
   	
   	public void setProductName(String productName){
   		this.productName = productName;
   	}
   	
   	public void setProductDescription(String productDescription){
   		this.productDescription = productDescription;
   	}
   	
   	public void setProductPrice(double productPrice){
   		this.productPrice = productPrice;
   	}
   	
   	public String getProductName(){
   		return productName;
   	}
   	
	public String getProductDescription(){
   		return productDescription;
   	}
   	
   	public double getProductPrice(){
   		return productPrice;
   	}
   	
   	public int getOrderedTimes(){
   		return orderedTimes;
   	}
   	
   	public boolean equals(Product p){
   		if(p.productName == productName){
   			return true;
   		}
   		else{
   			return false;
   		}
   	}
   	
   	public void addOrderedTimes(int quantity){
   		this.orderedTimes += quantity;
   	}
   	
   	public String toString(){
   		return String.format("%-20s %-70s %7.2f", productName, productDescription, productPrice);
   	}
}