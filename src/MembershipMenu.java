
//This module handled by: Chan Jia Min

import java.util.Date;
import java.util.Scanner;
import java.lang.Character;

public class MembershipMenu {
    
    public static void showMenu(){
		
		MemberAccount[] members = new MemberAccount[100];
	
    	int count = ReadWriteFiles.read(members,"MemberAccount.bin");
		MemberAccount.setMemberCount(count);
		
		Scanner s = new Scanner(System.in);
		int choice, index;
		do{
		
			System.out.println("Menu for Membership\n------------------");
			System.out.println("1.Create Member");
			System.out.println("2.Edit Member");
			System.out.println("3.Search Member");
			System.out.println("4.Delete Member");		
			System.out.println("5.Show all Members");		
			System.out.println("6.Back");		
			System.out.print("Enter Choice > ");		
			choice = s.nextInt();
			
			switch(choice){
				case 1: 
					createMember(members); 
					break;
				case 2: 
					editMember(members); 
					break;
				case 3: 
					index = searchMember(members);
					if(index == -1){
						System.out.println("Member not found!"); 
					}
					else{
						System.out.println("========  ==========        =============  ======"); 
						System.out.println("MemberId  MemberName        ContactNumber  Points"); 
						System.out.println("========  ==========        =============  ======"); 
						System.out.println(members[index].toString()); 
						System.out.println("========  ==========        =============  ======"); 
					}
					break;
				case 4: 
					deleteMember(members); 
					break;
				case 5: 
					displayAllMembers(members);
					break;
				case 6: 
					ReadWriteFiles.write(members,"MemberAccount.bin");
					System.out.println("Back to main menu..."); 
					break;					
				default: 
					System.out.println("Invalid choice!"); 
					break;				
			}
			
		} while(choice != 6);
		
    }
    
    public static void createMember(MemberAccount[] members){
		
		Scanner s = new Scanner(System.in);
			
		
		System.out.println("Menu for creating member\n----------------------");
		
		System.out.println("Membership details for Silver Member :");
		SilverMember.displayMembershipDetails();
		System.out.println();
		System.out.println("Membership details for Gold Member :");
		GoldMember.displayMembershipDetails();
		
    	System.out.print("Please select type of membership (S for silver, G for gold) > ");
    	Character type = Character.toUpperCase(s.nextLine().charAt(0));
    	
		while(type != 'S' && type != 'G'){
	    	System.out.println("Invalid choice!");
	    	type = Character.toUpperCase(s.nextLine().charAt(0));
		}
		
    	System.out.print("Please enter your name > ");
		String name = s.nextLine();

    	System.out.print("Please enter your contact number> ");
		String contact = s.nextLine();
		
    	if(type == 'S'){
    		members[MemberAccount.getMemberCount()] = new SilverMember(name,contact);
    	}
    	else if(type == 'G'){
    		members[MemberAccount.getMemberCount()] = new GoldMember(name,contact);
    	}
    	else{
			System.out.println("Member account creation not successful");
			return;
    	}
    	
		System.out.println("Member account created successful\nDetails:");
		System.out.println(members[MemberAccount.getMemberCount()-1].toString());
    	
    }
    
    public static void editMember(MemberAccount[] members){
    	
    	Scanner s = new Scanner(System.in);
    	int choice;
    	int index = searchMember(members);
    	
    	while(index == -1){
    		System.out.println("Member not found!");
    		index = searchMember(members);
    	}
    	
	 	System.out.println("Member id : " + members[index].getMemberId());
    	
		
    	do{
	 		System.out.println("What do you want to edit?");
			System.out.println("1. Name");
			System.out.println("2. Contact number");
			System.out.println("3. Done editing");
			
			choice = s.nextInt();
			
			s.nextLine(); //capture newline
			
			switch(choice){
				case 1:
					System.out.println("Old name : " + members[index].getMemberName());
					System.out.print("Enter Name > ");
					members[index].setMemberName(s.nextLine());
					System.out.println("New name : " + members[index].getMemberName());
					break;
				case 2:
					System.out.println("Old contact number : " + members[index].getMemberContact());
					System.out.print("Enter Contact Number > ");
					members[index].setMemberContact(s.nextLine());
					System.out.println("New contact number : " + members[index].getMemberContact());
					break;
				case 3:
					System.out.println("Back to membership menu...");
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
    	}while(choice!=3);
		
    }
    
    //This method will return the index of associated member in array
    public static int searchMember(MemberAccount[] members){
    	
    	Scanner s = new Scanner(System.in);
		System.out.print("                Please enter the member ID > ");
		String searchId = s.next();
		
    	for(int i = 0; i < MemberAccount.getMemberCount(); i++){
    		if(members[i].getMemberId().equals(searchId)){
    			return i;
    		}
    	}
    	
    	return -1;
    }
     
    public static void deleteMember(MemberAccount[] members){
    	
    	int index = searchMember(members);
    	boolean confirmation = false;
		Scanner s = new Scanner(System.in);
		
    	System.out.println("Member details to be deleted:\n" + members[index].toString());
    	System.out.print("Confirm to delete this member? (Y = yes) > ");
    	
    	if(Character.toUpperCase(s.next().charAt(0)) == 'Y'){
	    	for(int i = index; i < MemberAccount.getMemberCount(); i++){
				members[i] = members[i+1];
	    	}
	    	System.out.println("Member deleted successfully :') ");
	    	MemberAccount.setMemberCount(MemberAccount.getMemberCount()-1);
	    }else{
	    	System.out.println("Back to Membership Menu...') ");
	    }
    }
     
    public static void displayAllMembers(MemberAccount[] members){

		System.out.println("========  ==========        =============  ======"); 
		System.out.println("MemberId  MemberName        ContactNumber  Points"); 
		System.out.println("========  ==========        =============  ======"); 
		for(int i = 0; i < MemberAccount.getMemberCount(); i++){
			System.out.println(members[i].toString()); 
		}
		System.out.println("========  ==========        =============  ======"); 
    }
}
