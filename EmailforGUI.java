package Email_java;
import java.util.Random;
public class EmailforGUI {
	private String firstname;
	private String lastname;
	private String department;
	private String password;
	private String alternatemail;
	private String company_name;
	private int mailboxcapacity;
	public EmailforGUI(String firstname,String lastname,String department,int passwordLength,String company_name) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.department=department;
		this.company_name=company_name;
		this.password=generatePassword(passwordLength);
	}
	private String generatePassword(int length) {
		String password_characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
		Random rand=new Random();
		char[] passwordset=new char[length];
		for (int i = 0; i < length; i++) {
	        passwordset[i] = password_characters.charAt(rand.nextInt(password_characters.length()));
	    }
		return new String(passwordset);
		
	}
	public void setMailboxCapacity(int capacity) {
		if (capacity>0) {
			this.mailboxcapacity=capacity;
		}
	}
	public void setAlternateEmail(String alternatemail) {
		this.alternatemail=alternatemail;
	}
	public void setPassword(String newpassword) {
		this.password=newpassword;
	}
	public String displayInfo() {
		return "Name: " + firstname + " " + lastname + "\n"+
		       "Department: " + department + "\n"+
		       "Email: " + firstname.toLowerCase() + lastname.toLowerCase() + "@" + department + "." + company_name + ".com"+ "\n"+
		       "Password: " + password+"\n"+
		       "Alternate Email: " + alternatemail+"\n"+
		       "Mailbox Capacity: " + mailboxcapacity + "mb";
	}
}
