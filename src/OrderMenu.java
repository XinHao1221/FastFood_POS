

import java.util.Scanner;
import java.lang.Character;
import java.util.*;

class OrderMenu {
	
	public static void acceptCustomerOrder() {
    	
		MemberAccount[] members = new MemberAccount[100];
		Order[] orders = new Order[100]; 
		
		
		Order.setOrderNumber(ReadWriteFiles.read(orders,"Orders.bin")+1000);
		MemberAccount.setMemberCount(ReadWriteFiles.read(members,"MemberAccount.bin"));
		
		int counter = 0;
		
    	Scanner scan = new Scanner(System.in);
		int choice;
		
    	
    	char codition;
    	
    		do{
    			ProductMenu.displayProduct();
				OrderList[] orderlist = new OrderList[100];
				clearList(orderlist);
	    		do{
		    		codition = acceptOrder(orderlist);
		    		
		    	}while(codition != 'N' && codition != 'n');
		    			    	
		    	Payment payment = new Payment(orderlist);
				Order order = new Order(orderlist,payment);
		    	
		    	checkMember(members,payment);
		    	
		    	order.getPayment().displayTotalPayment();
		    	System.out.print("                    Next Order? (N = Exit) > ");
	    		codition = scan.next().charAt(0);
	    		
	    		orders[counter++] = order;
	    		
	    	}while(codition != 'N' && codition != 'n');
    	
    	ReadWriteFiles.write(orders,"Orders.bin");
    	ReadWriteFiles.write(members,"MemberAccount.bin");
    }
    
    public static void clearList(OrderList[] orderlist){
    	for(int i = 0; i < orderlist.length; i++){
    		orderlist[i] = null;
    	}
    	OrderList.setListNo(0);
    }
    	
    public static void checkMember(MemberAccount[] members, Payment payment){
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.print("               Are you a member? (Y = Yes) > ");
    	char response = scan.next().charAt(0);
    	double purchaseTotal = payment.calcTotalPrice();
    	
    	if(response == 'Y' || response == 'y'){

    		int memberIndex = MembershipMenu.searchMember(members);
    		
    		if(memberIndex == -1){
    			System.out.println("                              Invalid member");
    			return;
    		}
    		
    		System.out.println("                           Current points : " + members[memberIndex].getPoints());
    		
    		System.out.print("Do you want to use your points? (Y = yes) > ");
    		response = scan.next().charAt(0);
    		
    		if(response == 'Y' || response == 'y'){
    			
    			int amount;
	    		System.out.print("          How much points you want to use? > ");
	    		
	    		try{
	    			amount = scan.nextInt();
	    		}
	    		catch(InputMismatchException e){
	    			System.out.println("                     Please enter an digit!!!");
	    			System.out.print("                             Enter points > ");
	    			amount = scan.nextInt();
	    		}
    			
    			payment.setDiscountAllowed(members[memberIndex].usePoints(amount));
    			System.out.println("                              Current points : " + members[memberIndex].getPoints());
    		}
    		
    		members[memberIndex].addPoints(purchaseTotal);
    	}
    	else{
    		System.out.println("                              No points added");
    	}
    }
    
    public static char acceptOrder(OrderList[] orderlist){
    	
    	Scanner scan = new Scanner(System.in);

    	System.out.print("                              Enter choice > ");
    	int choice = getChoice();
    	System.out.print("                            Enter quantity > ");
    	int quantity = getQuantity();
    	
		orderlist[OrderList.getListNo()] = new OrderList(ProductMenu.product[choice-1],quantity);
		
    	System.out.print("                     Next Item? (N = Exit) > ");
    	char codition = scan.next().charAt(0);
    	
    	return codition;
    }

    public static int getChoice(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextInt();
    		}
    		catch(InputMismatchException e){
    			System.out.println("                     Please enter an digit!!!");
    			System.out.print("                              Enter choice > ");
    			scan.next();
    		}
    	}
    }
    
    public static int getQuantity(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextInt();
    		}
    		catch(InputMismatchException e){
    			System.out.println("                     Please enter an digit!!!");
    			System.out.print("                            Enter quantity > ");
    			scan.next();
    		}
    	}
    }
    
  
}
