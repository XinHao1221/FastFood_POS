
//This module handled by: Lim Kuan Xian

import java.util.Scanner;

public class ReportMenu {
    
    public static void showMenu() {
    	
    	Order[] orders = new Order[100];
    	
		Order.setOrderNumber(ReadWriteFiles.read(orders,"Orders.bin")+1000);
    	
   		int choice;
    	Scanner scan = new Scanner(System.in);
   		   		
    	System.out.println("===========");
    	System.out.println("Report Menu");
    	System.out.println("===========");
    	System.out.println("1. Daily Sales Report");
    	System.out.println("2. Product Based Sales Report");
    	do{
    		System.out.print("Select your choice : ");
    		choice = scan.nextInt();
    		if(choice != 1 && choice != 2){
    			System.out.println("Invalid Choice. Please choose a valid choice.");
    		}
    	}while(choice != 1 && choice != 2);
    	switch(choice){
    		case 1:
    			showDailyReport(orders);
    			break;
    		case 2:
    			showProductSales();
    			break;
    	}
    }
    
    public static void showDailyReport(Order[] orders){
    	
    	double totalSales = 0, totalSST = 0, totalServiceTax = 0, totalIncTax = 0, totalDiscount = 0;
    	
    	System.out.println("\n============");
    	System.out.println("Daily Report");
    	System.out.println("============");
    	System.out.printf("%-20s %-12s %-12s %-12s\n","Product", "Price (RM)", "Quantity", "Total (RM)");
    	System.out.println("--------------------------------------------------------------");
    	
    	for(int i = 0; i < Order.getOrderNumber()-1000 ; i++){
    		System.out.println(orders[i].toString());
    		System.out.println("--------------------------------------------------------------");
    		totalSales += orders[i].getPayment().getTotalPrice();
    		totalSST += orders[i].getPayment().calcTotalSST();
    		totalServiceTax += orders[i].getPayment().calcTotalTaxCharges();
    		totalDiscount += orders[i].getPayment().getDiscountAllowed();
    	}
    	totalIncTax = totalIncTax + totalSales + totalSST + totalServiceTax - totalDiscount;
    
 
       	System.out.println("\n+=+=+=+=+=+=+=+=+=+");
    	System.out.println("Daily Sales Summary");
    	System.out.println("+=+=+=+=+=+=+=+=+=+");
    	System.out.printf("Total Daily Sales exclude tax & SST (RM)       : %.2f\n", totalSales);
    	System.out.printf("Total SST Collected (RM)                       : %.2f\n", totalSST);
    	System.out.printf("Total Service Tax Collected (RM)               : %.2f\n", totalServiceTax);
    	System.out.printf("Total Member Points Discount (RM)              : %.2f\n", totalDiscount);
    	System.out.printf("Total Daily Sales include tax & SST & Discount : %.2f\n", totalIncTax);
    }
    
    public static void showProductSales(){
    	int totalQuantity = 0;
    	
    	System.out.println("\n====================");
    	System.out.println("Product Sales Report");
    	System.out.println("====================");
    	System.out.printf("%-20s %-70s %-7s %-15s %-12s\n","Product","Product Description", "  Price", "     Ordered Times", "   Total (RM)");
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    	
    	for (int i = 0; i < Product.typeOfProduct; i ++){
    		System.out.print(ProductMenu.product[i].toString());
    		System.out.printf("%15d %12.2f\n",ProductMenu.product[i].getOrderedTimes(), ProductMenu.product[i].getOrderedTimes() * ProductMenu.product[i].getProductPrice());
    		totalQuantity += ProductMenu.product[i].getOrderedTimes();
    	}
    	
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    	System.out.println("\n+=+=+=+=+=+=+=+");
    	System.out.println("Product Summary");
    	System.out.println("+=+=+=+=+=+=+=+");
    	System.out.printf("Total Quantity of Product Sold : %d\n\n", totalQuantity);
    }
    
}
