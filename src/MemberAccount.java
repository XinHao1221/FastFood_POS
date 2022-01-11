
//This module handled by: Chan Jia Min

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public abstract class MemberAccount implements Serializable {
	
	protected String memberId;
	protected String memberName;
	protected String memberContact;
	protected double points;

    private static int memberCount;
    
    protected MemberAccount(){memberCount++;}

    protected MemberAccount(String memberName, String memberContact){
    	
		this.memberName = memberName;
		this.memberContact = memberContact;
		memberId = "M" + (1001+memberCount); //Assign M1001 as 1st member
    	memberCount++;	
    	
    }
    
    public String getMemberId(){
    	return memberId;
    }
    
    public String getMemberName(){
    	return memberName;
    }
    
    public String getMemberContact(){
    	return memberContact;
    }
    
    public double getPoints(){
    	return points;
    }
        
    public void setMemberName(String name){
    	memberName = name;
    }
    
    public void setMemberContact(String contact){
    	memberContact = contact;
    }
	
	public abstract void addPoints(double purchaseTotal);
	
	//Use point will decrease given amount of points, returning the discount amount
	public double usePoints(double amount){
		points -= amount;
		return (amount/100); //100 points equivalent to RM1
	}
	
	public void displayPoints(){
		System.out.println("Current points : " + points);
	}
	
	public String toString(){
		return memberId + "\t  " + memberName + "\t        " + memberContact + "\t   " + points;
	}
	
    public static int getMemberCount(){  	
    	return memberCount;
    }
    
    public static void setMemberCount(int count){  	
    	memberCount = count;
    }
    
    public boolean equals(Object obj){
    	MemberAccount otherMember = (MemberAccount) obj;
    	if(memberId == otherMember.memberId){
    		return true;
    	}
    	return false;
    }
}

class GoldMember extends MemberAccount{	
	
	final private static MembershipDetails details = new MembershipDetails("Gold Membership","This membership provides you 20% card points for every puchase you made\nInitial balance : 500",new Date(118,10,02),0.2); 

	public GoldMember(){}
	
	public GoldMember(String memberName, String memberContact){
		super(memberName,memberContact);
		super.points = 500;
	}
	    
    public void addPoints(double purchaseTotal){
		points += purchaseTotal * details.getPointsRate();
	}
	
	public static void displayMembershipDetails(){
		System.out.println(details.toString());
	}
}

class SilverMember extends MemberAccount{

	final private static MembershipDetails details = new MembershipDetails("Silver Membership","This membership provides you 10% card points for every puchase you made\nInitial balance : 200",new Date(118,10,02),0.1);

	public SilverMember(){}

	public SilverMember(String memberName, String memberContact){
		super(memberName,memberContact);
		super.points = 200;
	}
        
    public void addPoints(double purchaseTotal){
		points += purchaseTotal * details.getPointsRate();
	}
	
	public static void displayMembershipDetails(){
		System.out.println(details.toString());
	}
}


class MembershipDetails {   
    		
 	private String membershipTitle;
	private String description;
	private Date dateIntroduced;
	final private double POINT_ACCUMULATION_RATE;	
	
	public MembershipDetails(){ POINT_ACCUMULATION_RATE=0; }
	
	public MembershipDetails(String membershipTitle, String description, Date dateIntroduced, double POINT_ACCUMULATION_RATE){
		this.membershipTitle = membershipTitle;
		this.description = description;	
		this.dateIntroduced = dateIntroduced;
		this.POINT_ACCUMULATION_RATE = POINT_ACCUMULATION_RATE;
	}

	public double getPointsRate(){
		return POINT_ACCUMULATION_RATE;
	}
	
	public String toString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Membership Title: " + membershipTitle + "\nDescription: " + description + "\nDate introduced: " + dateFormat.format(dateIntroduced);
	}
	
	public boolean equals(Object obj){
		MembershipDetails otherMemberDetail = (MembershipDetails) obj;
    	if(membershipTitle.equals(otherMemberDetail.membershipTitle)){
    		return true;
    	}
    	return false;
 	}
}


