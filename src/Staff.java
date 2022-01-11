
//This module handled by: Koh Xin Hao

public class Staff {
        
    private static int id = 1001;
    private int staffId;
    private String staffName;
    private char staffGender;
    private String icNo;
    private String telNo;
    private String jobPosition;
    
    public Staff(String staffName, char staffGender, String icNo, String telNo, String jobPosition) {
    	this.staffId = id;
    	this.staffName = staffName;
    	this.staffGender = staffGender;
    	this.icNo = icNo;
    	this.telNo = telNo;
    	this.jobPosition = jobPosition;
    	this.id++;
    }
    
    public Staff(){
    	this.staffId = id;
    	this.staffName = "";
    	this.staffGender = ' ';
    	this.icNo = "";
    	this.telNo = "";
    	this.jobPosition = "";
    	this.id++;
    }
   	
   	public void setStaffName(String staffName){
   		this.staffName = staffName;
   	}
   	
   	public void setStaffGender(char staffGender){
   		this.staffGender = staffGender;
   	}
   	
   	public void setIcNo(String icNo){
   		this.icNo = icNo;
   	}
   	
   	public void setTelNo(String telNo){
   		this.telNo = telNo;
   	}
   	
   	public void setJobPosition(String jobPosition){
   		this.jobPosition = jobPosition;
   	}
   	
   	public int getStaffId(){
   		return this.staffId;
   	}
   	
   	public String getStaffName(){
   		return this.staffName;
   	}
   	
   	public char getStaffGender(){
   		return this.staffGender;
   	}
   	
   	public String getIcNo(){
   		return this.icNo;
   	}
   	
   	public String getTelNo(){
   		return this.telNo;
   	}
   	
   	public String getJobPosition(){
   		return this.jobPosition;
   	}
   	
   	public boolean equals(Staff s){
   		if(s.staffId == this.staffId){
   			return true;
   		}
   		else{
   			return false;
   		}
   	}
   	
   	public String toString(){
   		return String.format("  %d   %-20s %c      %-14s   %-12s %-20s\n", staffId, staffName, staffGender, icNo, telNo, jobPosition);
   	}
}
