import java.util.Scanner;

public class LogIn {
    
    public LogIn() {
    	
    	char choice;
    	Scanner scan = new Scanner(System.in);
    	
    	do{
    		getUsernameAndPassowrd();
    		
    		System.out.print("Next Log In? (N = No) > ");
    		choice = scan.next().charAt(0);
    		
    	}while(choice != 'N' && choice != 'n');
    
    }
    
    public void getUsernameAndPassowrd(){
    	
    	Scanner scan = new Scanner(System.in);
    	String username, password;
    	
    	do{
    		System.out.print("Username: ");
	    	username = scan.nextLine();
	    	System.out.print("Password: ");
	    	password = scan.nextLine();
    	}while(validateUsernameAndPassword(username, password) == false);
    	
    	
    	
    	
    }
    
    public boolean validateUsernameAndPassword(String username, String password){
    	 if(username.equals("manager") ){
    	 	if(password.equals("******")){
    	 		managerMenu();
    	 	}
    	 }
    	 else if(username.equals("staff")){
    	 	if(password.equals("******")){
    	 		staffMenu();
    	 	}
    	 }
    	 else{
    	 	System.out.println("Invalid Username or Password!!!");
    	 	return false;
    	 }
    	 return true;
    }
    
    public void managerMenu(){
    	
   	

	int choice = 0;
	Scanner scan = new Scanner(System.in);
    	
		do{
	    	System.out.println("1. Staff Menu");
			System.out.println("2. Product Menu");
			System.out.println("3. Report Menu");
			System.out.println("4. Log Out");
			
			System.out.print("\nEnter Choice > ");
			choice = scan.nextInt();
	
			switch(choice){
				case 1: StaffMenu.showMenu(); 
					break;
				case 2: ProductMenu.showMenu(); 
					break;
				case 3: ReportMenu.showMenu(); 
					break;
				case 4: break;
				default: System.out.println("Invalid Choice!!! Please enter (1-4)!!!");
					break;
			}
    	}while(choice!=4);
    }
    
    public void staffMenu(){
    	int choice = 0;
			Scanner scan = new Scanner(System.in);
		    	
			do{
		    		System.out.println("1. Order Menu");
				System.out.println("2. Membership Menu");
				System.out.println("3. Product Menu");
				System.out.println("4. Log Out");
				
				System.out.print("\nEnter Choice > ");
			choice = scan.nextInt();
		
				switch(choice){
					case 1: OrderMenu.acceptCustomerOrder();
						break;
					case 2: MembershipMenu.showMenu();
						break;
					case 3: ProductMenu.showMenu(); 
						break;
					case 4: break;
					default: System.out.println("Invalid Choice!!! Please enter (1-4)!!!");
						break;
				}
			
		    }while(choice!=4);
    }
}
