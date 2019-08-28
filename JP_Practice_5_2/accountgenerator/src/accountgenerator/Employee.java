package accountgenerator;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable{

	private final String name, username, email;
	private String password;
	
	
	public Employee() {
		name = setName();
		username = setUserName(name);
		email = setEmail(username);
		password = setPassword(username);
	}//end constructor
	
	private String setPassword(String user) {
		//8 characters, uppercase and lowercase
		//Special character
		int maxLength = 8;
		//set the length of the initial password to 8 characters
		if(user.length() < maxLength)
			while(user.length() < maxLength)
				user+='*';
		    //endwhile
		else
			user = user.substring(0, 8);
		//endif
		//replace all vowels with an asterisk
		user = user.replaceAll("[aeiou]", "*");
		//find the first alphabetic character and set it to uppercase
		for(int i = 0; i < user.length(); i++)
			if(Character.isLetter(user.charAt(i))) {
				if(i==0) {
					user = user.substring(0, 1).toUpperCase() + user.substring(1);
					break;
				}
				else
					if(i==user.length()-1) {
						user = user.substring(0, i) + user.substring(i).toUpperCase() ;
						break;
					}
					else {	
				       String str1 = user.substring(0, i);
				       String str2 = user.substring(i, i+1).toUpperCase(); 
				       String str3 = user.substring(i+1);
				       user = str1+str2+str3;
				       break;
					}
			}//endif
		return user;
	}//end method setPassword
	
	private String setEmail(String user) {
		int pos;
		
		pos = user.indexOf('.');
		return user.charAt(0) + user.substring(pos+1) + "@oracleacademy.Test";
	}//end method setEmail
	
	private String setUserName(String name) {
		name = name.toLowerCase();
		return name.replace(' ', '.');
	}//end method setUserName
	
	private String setName() {
		Scanner in = new Scanner(System.in);
		int charCount = 0;
		String name;
		do {
		   System.out.print("Please enter employee's first and last name: ");
		   name = in.nextLine();
		   charCount = countChars(name, ' ');
		}while(charCount!=1);
		in.close();
		return name;
	}//end method setName
	
    private int countChars(String str, char ch)
    {
    	int count = 0;
        for(int i=0; i< str.length(); i++)
        {
        	if(str.charAt(i)==ch)
            	count++;
        }//endfor
        return count;
    }//end method countChars

    public String toString() {
    	return "Employee Details" 
            +"\nName             : " + this.name 
            +"\nUsername         : " + this.username
            +"\nEmail            : " + this.email
            +"\nInitial Password : " + this.password;
    }//end method toString
    
    
}//end class Employee
