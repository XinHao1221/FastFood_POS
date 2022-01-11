

import java.io.Serializable;

class OrderList implements Serializable{
	
	private Product product;
	private int quantity;
	private static int listNo;
	
	OrderList(){
	}
	
	OrderList(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
		product.addOrderedTimes(quantity);
		listNo++;
	}
	
	public double calcSubTotal(){
		return product.getProductPrice() * quantity;
	}
	
	public static int getListNo(){
		return listNo;
	}
	
	public static void setListNo(int listNo){
		OrderList.listNo = listNo;
	}
	
	public String toString(){
		return String.format("%-20s %-12.2f %-12d %-12.2f",product.getProductName(), product.getProductPrice(), quantity, product.getProductPrice() * quantity); 
	}
	
}
