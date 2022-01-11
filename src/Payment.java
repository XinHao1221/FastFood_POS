

import java.util.Scanner;
import java.io.Serializable;

public class Payment implements Serializable{
	
	private double grandTotal;
	private OrderList[] orderlist;
    private double totalPrice;
    private double discountAllowed;
	private static double taxRate = 0.1;
	private static double sst = 0.06;

	
    public Payment() {
    }
    
    public Payment(OrderList[] orderlist) {
    	this.orderlist = orderlist;
    }
    
    public double calcTotalPrice(){
    	for(int i = 0; i < OrderList.getListNo(); i++){
    		totalPrice += orderlist[i].calcSubTotal();
    	}
    	return totalPrice;
    }
    
   	public double getTotalPrice(){
   		return totalPrice;
   	}
   	
    
    public double calcTotalTaxCharges(){
    	return totalPrice * taxRate;
    }
    
    public double calcTotalSST(){
    	return totalPrice * sst;
    }
    
    public void setDiscountAllowed(double discountAllowed){
    	this.discountAllowed = discountAllowed;
    }
    
    public double getDiscountAllowed(){
    	return discountAllowed;
    }
    
    public void displayTotalPayment(){
    	
    	Scanner scan = new Scanner(System.in);
    	double amount;
    	int codition = -1;
    	
    	System.out.printf("                       Total: %.2f\n", getTotalPrice());
    	System.out.printf("                    SST (6%%): %.2f\n", calcTotalSST());
    	System.out.printf("       Service Charges (10%%): %.2f\n", calcTotalTaxCharges());
    	grandTotal = getTotalPrice() + calcTotalSST() + calcTotalTaxCharges() - discountAllowed;
    	if(discountAllowed != 0)
    		System.out.printf("      Member points discount: -%.2f\n", discountAllowed);
    	System.out.printf("                 Grand Total: %.2f\n", grandTotal);
    	do{
    		System.out.print("                Enter Amount: ");
	    	amount = scan.nextDouble();
	    	
	    	if((amount - grandTotal) >= 0){
	    		System.out.printf("               Change Amount: %.2f\n", (amount - grandTotal));
	    		System.out.println("Payment accepted, Thank you!!!");
	    		codition = 1;
	    	}
	    	else{
	    		System.out.println("Not enough money paid!!!");
	    	}
	    	
    	}while(codition == -1);
    	
    }
  	
  	public String toString(){
  		return String.format("\n%46s %.2f\n%46s %.2f\n%46s %.2f\n%46s %.2f\n%46s %.2f", "Total : ", totalPrice, "SST (6%) : ", calcTotalSST(), "Service Charges (10%) : ", calcTotalTaxCharges(), "Member points discount : ", discountAllowed, "Grand Total : ", grandTotal);                                                                                                                                                                                                                                                                                                                             
  	}
}
