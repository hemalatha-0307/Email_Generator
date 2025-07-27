package Email_java;
import java.util.Scanner;
import java.util.Random;

public class Email {
	private String firstname;
	private String lastname;
	private String department;
	private String password;
	private String alternatemail;
	private String company_name;
	int mailboxcapacity;
	public Email(String firstname,String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.department=setDepartment();
		Scanner give=new Scanner(System.in);
		System.out.println("Enter the password length: ");
		int passwordlength=give.nextInt();
		give.nextLine();
		System.out.println("Enter the company name: ");
		String cn=give.nextLine();
		this.company_name=cn;
		this.password=generatepassword(passwordlength);
		
	}
	private String setDepartment() {
		System.out.println("Choose the Department: ");
		System.out.println("1 for engineering");
		System.out.println("2 for development");
		System.out.println("3 for accounting");
		System.out.println("4 for Technical support");
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your choice: ");
		int choice=input.nextInt();
		if(choice==1) {
			return "engineering";
		}
		else if(choice==2) {
			return "development";
		}
		else if(choice==3) {
			return "accounting";
		}
		else if(choice==4) {
			return "techsupport";
		}
		else {
			return "";
		}
		
	}
	private String generatepassword(int length) {
		String password_characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
		Random rand=new Random();
		char[] passwordset=new char[length];
		for (int i = 0; i < length; i++) {
	        passwordset[i] = password_characters.charAt(rand.nextInt(password_characters.length()));
	    }
		return new String(passwordset);
		
	}
	public void setmailboxcapacity(int capacity) {
		this.mailboxcapacity=capacity;
	}
	public void setalternatemail(String alternatemail) {
		this.alternatemail=alternatemail;
	}
	public void setpassword(String newpassword) {
		this.password=newpassword;
	}
	public void displayInfo() {
		System.out.println("Name: " + firstname + " " + lastname);
		System.out.println("Department: " + department);
		System.out.println("Email: " + firstname.toLowerCase() + lastname.toLowerCase() + "@" + department + "." + company_name + ".com");
		System.out.println("Password: " + password);
		System.out.println("Alternate Email: " + alternatemail);
		System.out.println("Mailbox Capacity: " + mailboxcapacity + "mb");
	}
}
