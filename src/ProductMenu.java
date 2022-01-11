
//This module handled by: Koh Xin Hao

import java.util.Scanner;
import java.util.*;

public class ProductMenu {
	
	static Product []product = new Product[100];
	private static int typeOfProduct = 5;
    
    public static void showMenu() {
    	
    	int choice;
    	
    	do{
	    	
	    	choice = displaySelection();
	    	
	    	switch(choice){
	    		case 1: addProduct(); break;
	    		case 2: modifyProductDetail(); break;
	    		case 3: displayProduct(); break;
	    		case 4: break;
	    		default: System.out.println("Invalid Choice!!!\nPlease enter (1-3)!!!");
	    	}
    		
    		System.out.print("\n");
    		
    	}while(choice != 4);
    }
    
    //Display the selection to user
    public static int displaySelection(){
    	
    	Scanner scan = new Scanner(System.in);
    	int choice;
    	
    	System.out.println("1. Add Product");
	    	System.out.println("2. Modify Product");
	    	System.out.println("3. Display Product");
	    	System.out.println("4. Exit");
	    	
	    	System.out.print("\nEnter your choice > ");
	    	choice = getInt();
	    	
	    	return choice;
    }
    
    //Initialize product information to the product class
    public static void productInitialization(){
  		
    	product[0] = new Product("Chicken Burger Set", "Chicken Burger + French Fries + Coca-Cola", 10.50);
    	product[1] = new Product("Beef Burger Set", "Beef Burger + French Fries + Coca-Cola", 12.50);
    	product[2] = new Product("Fried Chicken Set", "2pcs Fried Chicken + Onion Rings + Coca-Cola", 13.50);
    	product[3] = new Product("Big Chicken Set", "Double Chicken Burger + French Fries + Coca-Cola", 15.50);
    	product[4] = new Product("Big Beef Set", "Double Beef Burger + Onion Rings + Chicken Nuggets + CocaCola", 18.50);
    }
    
    //Allow user to add new product
    public static void addProduct(){
    	
    	Scanner scan = new Scanner(System.in);	
    		
    	String productName, productDescription;
    	double productPrice = 0.00;
    	char codition;
     	
     	System.out.print("\n");
    	do{
    		System.out.println("Product No." + (typeOfProduct + 1));
    		System.out.print("Product Name > ");
    		productName = scan.nextLine();
    		System.out.print("Product Description > ");
    		productDescription = scan.nextLine();
    		System.out.print("Product Price(RM) > ");
    		productPrice = getDouble();
    		
    		product[typeOfProduct] = new Product();
    		
    		product[typeOfProduct].setProductName(productName);
    		product[typeOfProduct].setProductDescription(productDescription);
    		product[typeOfProduct].setProductPrice(productPrice);
    		
    		typeOfProduct++;
    		
    		System.out.print("\nEnter next product? (N = exit) > ");
    		codition = scan.next().charAt(0);
    		scan.nextLine();
    		System.out.print("\n");
    		
    	}while(codition != 'n' && codition != 'N');	
    		
    	
    	System.out.println("Updated Product Details:");	
    	System.out.println("No. Product Name                       Product Description                                     Price(RM)");
    	System.out.println("--- -------------------- -------------------------------------------------------------------- -----------");
    	for(int i = 0; i < typeOfProduct; i++){
    		System.out.printf("%2d. %s\n", (i+1), product[i].toString());
    	}
    	System.out.println("--------------------------------------------------------------------------------------------------------");
    	System.out.println("  " + typeOfProduct + " product(s) listed");
    	
    }
    
    //Display all the product information to user
    public static void displayProduct(){
    	
    	System.out.println("\nProduct Details:");	
    	System.out.println("No. Product Name                       Product Description                                     Price(RM)");
    	System.out.println("--- -------------------- -------------------------------------------------------------------- -----------");
    	for(int i = 0; i < typeOfProduct; i++){
    		System.out.printf("%2d. %s\n", (i+1), product[i].toString());
    	}
    	System.out.println("--------------------------------------------------------------------------------------------------------");
    	System.out.println("  " + typeOfProduct + " product(s) listed");
    }
    
    //Allow user to modify the product detail
    public static void modifyProductDetail(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	String productName, productDescription;
    	double productPrice;
    	int itemNo, choice = 0;
    	boolean validateProductNo = false;
    	
    	System.out.println("\nProduct Details:");	
    	System.out.println("No. Product Name                       Product Description                                     Price(RM)");
    	System.out.println("--- -------------------- -------------------------------------------------------------------- -----------");
    	for(int i = 0; i < typeOfProduct; i++){
    		System.out.printf("%2d. %s\n", (i+1), product[i].toString());
    	}
    	System.out.println("--------------------------------------------------------------------------------------------------------");
    	System.out.println("  " + typeOfProduct + " product(s) listed");
    	
    	do{
    		System.out.print("\nPlease enter the number of the product to be modify > ");
	    	itemNo = getNumberOfProduct();
	    	
	    	if(!(itemNo > typeOfProduct)){
	    		validateProductNo = true;
	    	}
	    	else{
	    		System.out.print("Product No. Not Found!!!");
	    	}
    	}while(validateProductNo == false);
    	
    	do{
	    	System.out.printf("\nWhich Element to be modified?\n");
	    	System.out.print("1. Product Name\n");
	    	System.out.print("2. Product Description\n");
	    	System.out.print("3. Product Price(RM)\n");
	    	System.out.print("4. Exit");
	    	
	    	System.out.print("\nEnter your choice > ");
	    	choice = getInt();
	    	
	    	if(choice != 4){
		    	switch(choice){
		    		case 1: System.out.print("\nProduct Name > ");
		    				productName = scan.nextLine();
		    				product[itemNo - 1].setProductName(productName);
		    				displayUpdatedProductDetail(product[itemNo - 1]);
		    				break;
		    		case 2: System.out.print("\nProduct Description > ");
		    				productDescription = scan.nextLine();
		    				product[itemNo - 1].setProductDescription(productDescription);
		    				displayUpdatedProductDetail(product[itemNo - 1]);
		    				break;
		    		case 3: System.out.print("\nProduct Price > ");
		    				productPrice = getDouble();
		    				product[itemNo - 1].setProductPrice(productPrice);
		    				displayUpdatedProductDetail(product[itemNo - 1]);
		    				break;
		    		default: System.out.println("Invalid Selection!!!\nPlease enter (1-4)!!!");
	    		}
	    		
	    		

	    	}
    	
    	}while(choice != 4);	
    }
    
    //Display the updated product detail to the user
    public static void displayUpdatedProductDetail(Product product){
    	
    	System.out.println("Updated record");
	    System.out.println("No. Product Name                       Product Description                                     Price(RM)");
		System.out.println("--- -------------------- -------------------------------------------------------------------- -----------");
		System.out.printf(" 1. %s\n", product.toString());
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
	    		
	    System.out.println("Modify another element?");
    }
    
    //Try catch the double variable from user
    public static double getDouble(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextDouble();
    		}
    		catch(InputMismatchException e){
    			System.out.println("Price my be in digit!!!");
    			System.out.print("Product Price(RM) > ");
    			scan.next();
    		}
    	}
    }
    
    //Try catch the int variable from user
    public static int getInt(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextInt();
    		}
    		catch(InputMismatchException e){
    			System.out.println("Please enter an digit!!!");
    			System.out.print("Enter your choice > ");
    			scan.next();
    		}
    	}
    }
    
    //Try catch the number of product from user
    public static int getNumberOfProduct(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextInt();
    		}
    		catch(InputMismatchException e){
    			System.out.println("Please enter an digit!!!");
    			System.out.print("Please enter the number of the product to be modify > ");
    			scan.next();
    		}
    	}
    }
}
