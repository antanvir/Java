package RE;

import java.util.*;
import java.util.regex.*;

public class PatternMatching {

	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);
		
		String email = "^[a-zA-Z0-9./_!@#%$&?+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
		
		String name = "^([a-zA-Z]+[ .'_-]*)+$";
		
		String password ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
		
		
		/*Pattern ptrn = Pattern.compile(email);
		System.out.println("Enter an email: ");
		
		Matcher mtchr = ptrn.matcher(input.nextLine());
		
		System.out.println(mtchr.find()?"Match found :)" :"Match not found :(");
		*/
		/*Pattern ptrn1 = Pattern.compile(name);
		System.out.println("Enter a name: ");
		
		Matcher mtchr1 = ptrn1.matcher(input.nextLine());
		
		System.out.println(mtchr1.find()?"Match found :)" :"Match not found :(");
		*/
		
		Pattern ptrn2 = Pattern.compile(password);
		System.out.println("Enter a password: ");
		
		Matcher mtchr2 = ptrn2.matcher(input.nextLine());
		
		System.out.println(mtchr2.find()?"Match found :)" :"Match not found :(");
	
	}

}
