
//This module handled by: Chan Jia Min

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.ObjectStreamClass; 
import java.io.IOException; 

class ReadWriteFiles {
	
	public ReadWriteFiles(){
	}

	public static void write(Object[] obj, String filename){
	    	            
	       // Serialization  
	        try
	        {    
			    //Saving of object in a file 
		        FileOutputStream fileOut = new FileOutputStream(filename); 
		        ObjectOutputStream objOut = new ObjectOutputStream(fileOut); 
			    // Method for serialization of object 
				for(int i = 0; i < obj.length; i++){
		            objOut.writeObject(obj[i]); 
				}  
	            objOut.close(); 
	            fileOut.close(); 
	              
	            System.out.println("Object has been serialized and written into " + filename); 
	  
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
		
  	}
	
	public static int read(Object[] obj, String filename){
			
			int counter = 0;
			
		    try {
		    	
				FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
					 		    	
				for(int i = 0; i < obj.length; i++){
					
					Object o = objIn.readObject();
					
					if(o instanceof SilverMember){
						obj[i] = (SilverMember) o;
						counter++;
					}
					else if(o instanceof GoldMember){
						obj[i] = (GoldMember) o;
						counter++;
					}
					else if(o instanceof Order){
						obj[i] = (Order) o;
						counter++;
					}
					else{
						
					}
					
				}
				
		     	fileIn.close();
		  		objIn.close();
		   		
		    } catch (IOException exIO) {
		       //exIO.printStackTrace();
		       
		    } catch (ClassNotFoundException exClass) {
		       System.out.println("Class not found");
		       //exClass.printStackTrace();
		    }
		    
			System.out.println("Successfully Read " + counter + " items from " + filename);
		    return counter;
	}
}
