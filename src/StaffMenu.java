
//This module handled by: Koh Xin Hao

import java.util.Scanner;
import java.lang.Character;
import java.util.*;
 
public class StaffMenu {
	
	static Staff []staff = new Staff[100];
	private static int numberOfStaff = 5;
    
    public static void showMenu() {
    	
    	int choice;
    	Scanner scan = new Scanner(System.in);
    	
    	staffInitialization();
    	
    	do{
	     	choice = displaySelection();
	    	
	    	switch(choice){
	    		case 1: addStaff(); break;
	    		case 2: modifyStaff(); break;
	    		case 3: displayStaff(); break;
	    		case 4: break;
	    		default: System.out.println("Invalid Choice!!!\nPlease enter (1-3)!!!\n");
	    	}
    	}while(choice != 4);
    }
    
    //Initialize all the staff detal to the staff class
    public static void staffInitialization(){
    	staff[0] = new Staff("Katti", 'F', "980105-01-5836", "012-7209601", "Chef");
    	staff[1] = new Staff("Harman", 'M', "960224-03-9945", "010-4415617", "Chef");
    	staff[2] = new Staff("Paul", 'M', "990405-10-3347", "014-6430706", "Cashier");
    	staff[3] = new Staff("Shayna", 'F', "970126-05-6968", "010-1440696", "Waiter");
    	staff[4] = new Staff("Benson", 'M', "001221-01-0185", "019-5227937", "Manager");
    }
    
    //Dsipaly selection to user
    public static int displaySelection(){
    	
    	Scanner scan = new Scanner(System.in);
    	int choice;
    	
  		System.out.println("\n1. Add Staff Record");
	    System.out.println("2. Modify Staff Record");
	    System.out.println("3. Display Staff Record");
	    System.out.println("4. Exit\n");
	    	
	    System.out.print("Enter your choice > ");
	   	choice = getInt();
	   	
	   	return choice;
    }
    
    //Allow the user to add new staff
    public static void addStaff(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	String staffName, icNo, telNo, jobPosition;
	    char staffGender, codition;
	    
	    System.out.println("\n");
	    
	    do{
	    	System.out.print("Staff ID: " + (1001 + numberOfStaff) + "\n");
	    	System.out.print("Staff Name > ");
	    	staffName = scan.nextLine();
	    	
	    	do{
	    		System.out.print("Gender (M = Male or F = Female) > ");
	    		staffGender = Character.toUpperCase(scan.next().charAt(0));
	    	}while(validateStaffGender(staffGender) == false);
	    	
	    	scan.nextLine();
	    	
	    	do{
	    		System.out.print("IC No (Exp:001221-01-0195) > ");
	    		icNo = scan.nextLine();
	    	}while(validateIcNo(icNo) == false);
	    	
	    	do{
	    		System.out.print("Telephone Number (Exp:012-3456789) > ");
	    		telNo = scan.nextLine();
	    	}while(validateTelephoneNo(telNo) == false);
	    		
	    	do{
	    		System.out.print("Job Position (Only letter) > ");
	    		jobPosition = scan.nextLine();
	    	}while(validateJobPosition(jobPosition) == false);
	    	
	    	
	    	System.out.print("\n");
	    	
	    	staff[numberOfStaff] = new Staff();
	    	
	    	staff[numberOfStaff].setStaffName(staffName);
	    	staff[numberOfStaff].setIcNo(icNo);
	    	staff[numberOfStaff].setStaffGender(staffGender);
	    	staff[numberOfStaff].setTelNo(telNo);
	    	staff[numberOfStaff].setJobPosition(jobPosition);
	    	
	    	numberOfStaff++;
	    	
	    	System.out.print("Add another staff? (N = exit) > ");
	    	codition = scan.next().charAt(0);
	    	scan.nextLine();
	    	
	    	System.out.print("\n");
	    }while(codition != 'n' && codition != 'N');	
	    	
	   System.out.println("Updated Staff Details:");
	   System.out.println("Staff ID Staff Name         Gender      IC No.       Telphone No.  Job Position");
	   System.out.println("-------- ------------------ ------ ----------------- ------------- ---------------------");
	   for(int i = 0; i < numberOfStaff; i++){
	   		System.out.print(staff[i].toString());
	   }
	   System.out.println("-----------------------------------------------------------------------------------------");
	   System.out.println("  " + numberOfStaff + " staff(s) listed\n");

    }
    
    //Allow the user to modify existing staff's detail
    public static void modifyStaff(){
    
    	Scanner scan = new Scanner(System.in);
    	
    	int staffId, choice;
    	String staffName, icNo, telNo, jobPosition;
	    char staffGender;
	    boolean valiateStaffId = false;
    	
        System.out.println("\nStaff Details:");
	    System.out.println("Staff ID Staff Name         Gender      IC No.       Telphone No.  Job Position");
	    System.out.println("-------- ------------------ ------ ----------------- ------------- ---------------------");
	    for(int i = 0; i < numberOfStaff; i++){
	   		System.out.print(staff[i].toString());
	    }
	    System.out.println("-----------------------------------------------------------------------------------------");
	    System.out.println("  " + numberOfStaff + " staff(s) listed\n\n");
	   	
	   	do{
	   		System.out.print("Please enter staff id to be modify > ");
	    	staffId = getStaffId();
	    	
	    	for(int i = 0; i < numberOfStaff; i++){
	    		if(staff[i].getStaffId() == staffId){
	    			valiateStaffId = true;
	    		}
	    	}
	    	
	    	if(valiateStaffId == false){
	    		System.out.println("Staff ID not found!!!\n");
	    	}
	    	
	   	}while(valiateStaffId == false);
    	
    	do{
    		System.out.printf("\nWhich Element to be modified?\n");
    		System.out.println("1. Staff Name");
    		System.out.println("2. Gender");
    		System.out.println("3. IC No. ");
    		System.out.println("4. Telephone No.");
    		System.out.println("5. Job Position");
    		System.out.println("6. Exit");
    		
    		System.out.print("\nEnter your choice > ");
	    	choice = getInt();
	    	
	    	if(choice != 6){
	    		switch(choice){
	    			case 1: System.out.print("Staff Name > ");
	    			        staffName = scan.nextLine();
	    			        staff[staffId -1001].setStaffName(staffName);
	    			        displayUpdatedRecord(staff[staffId -1001]);
	    			        break;
	    			case 2: do{
					    		System.out.print("Gender (M = Male or F = Female) > ");
					    		staffGender = Character.toUpperCase(scan.next().charAt(0));
					    	}while(validateStaffGender(staffGender) == false);
					    	scan.nextLine();
	    			        staff[staffId -1001].setStaffGender(staffGender);
	    			        displayUpdatedRecord(staff[staffId -1001]);
	    			        break;
	    		    case 3: do{
					    		System.out.print("IC No (Exp:001221-01-0195) > ");
					    		icNo = scan.nextLine();
					    	}while(validateIcNo(icNo) == false);
	    		            staff[staffId -1001].setIcNo(icNo);
	    		            displayUpdatedRecord(staff[staffId -1001]);
	    		            break;
	    		    case 4: do{
					    		System.out.print("Telephone Number (Exp:012-3456789) > ");
					    		telNo = scan.nextLine();
					    	}while(validateTelephoneNo(telNo) == false);
	    		            staff[staffId -1001].setTelNo(telNo);
	    		            displayUpdatedRecord(staff[staffId -1001]);
	    		            break;
	    		    case 5: do{
					    		System.out.print("Job Position (Only letter) > ");
					    		jobPosition = scan.nextLine();
					    	}while(validateJobPosition(jobPosition) == false);
	    		            staff[staffId -1001].setJobPosition(jobPosition);
	    		            displayUpdatedRecord(staff[staffId -1001]);
	    		            break;
	    		    default: System.out.println("Invalid Selection!!!\nPlease enter (1-6)!!!");
	    		}
	    			
	    	}
    	}while(choice != 6);
    }
    
    //Display all staff record
    public static void displayStaff(){
    	
    	System.out.println("\nStaff Details:");
    	System.out.println("Staff ID Staff Name         Gender      IC No.       Telphone No.  Job Position");
	    System.out.println("-------- ------------------ ------ ----------------- ------------- ---------------------");
	    for(int i = 0; i < numberOfStaff; i++){
	    		System.out.print(staff[i].toString());
	    }
	    System.out.println("-----------------------------------------------------------------------------------------");
	    System.out.println("  " + numberOfStaff + " staff(s) listed\n");
	   
    }
    
    //Display the updated staff record
    public static void displayUpdatedRecord(Staff staff){
    	
    	System.out.println("\nUpdated record");
	    System.out.println("Staff ID Staff Name         Gender      IC No.       Telphone No.  Job Position");
		System.out.println("-------- ------------------ ------ ----------------- ------------- ---------------------");
		System.out.print(staff.toString());
		System.out.println("-----------------------------------------------------------------------------------------\n");
				    
	    System.out.println("Modify another element?");
    }
    
    //Validate the gender input by the user
    public static boolean validateStaffGender(char staffGender){
    	
    	if(staffGender == 'M' || staffGender == 'F'){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //Validate the ic no format that input by the user
    public static boolean validateIcNo(String icNo){
    	
    	String []validate = icNo.split("-");
    	boolean valid = false;
    	
    	if(validate.length != 3){
    		return false;
    	}
    	
    	if(validate[0].length() == 6){
    		if(validate[1].length() == 2){
    			if(validate[2].length() == 4){
    				valid = true;
    			}
    			else{
		    		return false;
		    	}
    		}
    		else{
	    		return false;
	    	}
    	}
    	else{
    		return false;
    	}
    	
    	for(int i = 0; i < validate.length; i++){
    		for(int j = 0; j < validate[i].length(); j++){
    			if((Character.isDigit(validate[i].charAt(j))) == false){
    				return false;
    			}	
    		}
    	}
    	
    	return valid;
    }
    
    //Validate the phone no. format that input by the user
    public static boolean validateTelephoneNo(String telNo){
    	
    	String []validate = telNo.split("-");
    	boolean valid = false;
    	
    	if(validate.length != 2){
    		return false;
    	}
    	
    	if(validate[0].length() == 3){
    		if(validate[1].length() == 7 || validate[1].length() == 8){
    			valid = true;
    		}
    		else{
    			return false;
    		}
    	}
    	else{
    		return false;
    	}
    	
    	if(!(validate[0].charAt(0) == '0' && validate[0].charAt(1) == '1')){
    		return false;
    	}
    	
    	for(int i = 0; i < validate.length; i++){
    		for(int j = 0; j < validate[i].length(); j++){
    			if((Character.isDigit(validate[i].charAt(j))) == false){
    				return false;
    			}
    		}
    	}
    	
    	return valid;
    	
    }
    
    //Validate the job position that input by the user
    public static boolean validateJobPosition(String jobPosition){
    	
    	for(int i = 0; i < jobPosition.length(); i++){
    		if((Character.isLetter(jobPosition.charAt(i))) == false){
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    //try catch int variable from user
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
    
    //try catch staff Id from user
    public static int getStaffId(){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true){
    		try{
    			return scan.nextInt();
    		}
    		catch(InputMismatchException e){
    			System.out.println("Staff ID is in digit form!!!");
    			System.out.print("Please enter staff id to be modify > ");
    			scan.next();
    		}
    	}
    }
}
