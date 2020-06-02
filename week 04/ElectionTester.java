import java.util.Scanner;

public class ElectionTester 
{
	public static void main(String[] args) 
	{
		MyDate election = new MyDate(2019, 3, 24);
		
		Person a = new Person("Lalisa", "Manoban", 1997, 3, 27);
		printPersonElectionInfo(a, election);
		
		Person b = new Person("Nuda", "Inter", 2012, 1, 16);
		printPersonElectionInfo(b, election);
		
		// Create another Person object with your information
		// Print your information, age, and election eligibility.
		
		Person c = new Person("Nattawipa", "Saetae", 2000, 7, 27);
		printPersonElectionInfo(c, election);
		
		// Write a program to take 3 persons information from the user
		// (Hint: Use scanner and for loop to get input)
		
		// Challenge Bonus
		// Instead of taking 3 persons' information, write a program to continuously take input from the user
		// until the user types 'q' to quite the program.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		for(int i=0;i<3;i++)
		{
			Scanner user = new Scanner(System.in);
			System.out.print("Enter Firstname or type 'q' to exit : ");
			String firstname = user.next();
			if (firstname.equals("q"))
			{
				System.out.println("Exit the program. Thank you.");
				break;
			}
			System.out.print("Enter Lastname : ");
			String lastname = user.next();
			System.out.print("Enter year of birthday : ");
			int year = user.nextInt();
			System.out.print("Enter month of birthday : ");
			int month = user.nextInt();
			System.out.print("Enter day of birthday : ");
			int day = user.nextInt();
			
			Person d = new Person(firstname, lastname, year, month, day);
			printPersonElectionInfo(d, election);
		}	
	}
	
	public static void printPersonElectionInfo(Person p, MyDate election) 
	{
		p.printPersonInfo();
		System.out.println("Age: " + p.getAge(election));
		if(p.isEligible(election))
			System.out.println("This person is eligible to vote.");
		else
			System.out.println("This person is NOT eligible to vote");
		
		System.out.println("-----------------------------------");
	}
}
