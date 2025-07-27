package Email_java;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter first name: ");
		String fn=input.nextLine();
		
		System.out.println("Enter last name: ");
		String ln=input.nextLine();
		
		Email obj=new Email(fn,ln);
		
		System.out.println("Enter Mailbox Capacity: ");
		int c=input.nextInt();
		input.nextLine();
		obj.setmailboxcapacity(c);
		
		System.out.println("Enter an Alternate email: ");
		String ae=input.nextLine();
		obj.setalternatemail(ae);
		
		System.out.println("Do you want to change your password: Yes/No");
		String answer=input.nextLine();
		if(answer.equalsIgnoreCase("Yes")) {
			System.out.println("Enter the new password: ");
			String np=input.nextLine();
			obj.setpassword(np);
		}
		System.out.println(" ");
		obj.displayInfo();
		
	}
}
