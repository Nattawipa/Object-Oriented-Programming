
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting 
{
	public static List<String> Reading(String TextFile) 
	{
		List<String> unsorted = new ArrayList<String>();
		try 
		{
			BufferedReader line = new BufferedReader(new FileReader(TextFile));
			String currentline = line.readLine();
			String[] Split = null; 
			while (currentline != null) 
			{
				Split = currentline.split(" ");

				for (String whatever : Split)
				{
					unsorted.add(whatever);
				}
				currentline = line.readLine();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return unsorted; 

	}

	public static void Print(List<String> Printlist) 
	{
		System.out.println(Printlist);

	}

	public static void Sort(List<String> ListSorted) 
	{
		for (int i = 0; i < ListSorted.size(); i++) 
		{
		for (int j = 0; j < i; j++) 
		{
		    if (ListSorted.get(j).compareTo(ListSorted.get(i)) < 0)
		    {
		    	String temp = ListSorted.get(i); 
		    	for (int k = i; k > j; k--) 
		    	{
		    		ListSorted.set(k, ListSorted.get(k - 1)); 
		    	}
		     ListSorted.set(j, temp); 

		    }
		   }
		   if (i == 0) 
		   {
			   System.out.print("Original :");
			   Print(ListSorted);
		   }
		   else 
		   {
		    System.out.print("Pass " + i + " :");
		    Print(ListSorted);
		   }

		  }

		 }
		////////////////BONUS START HERE/////////////////
	public static boolean isPalindrome(String word) 
	{	  
		String cleanWord = word.replaceAll("[^a-zA-Z0-9]","").replaceAll("\\?", "").replaceAll("\\!", "").replaceAll("\"", "").replaceAll("," , "").toLowerCase();
		return checkPalindrome(cleanWord);
	}
	private static boolean checkPalindrome(String word) 
	{
		if(word.length() < 2) 
		{ 
			return true; 
		}
		 char first  = word.charAt(0);
		 char last   = word.charAt(word.length()-1);
		 if(  first != last  ) 
		 { 
			 return false;
		 }
		 else 
		 { 
			  return checkPalindrome(word.substring(1,word.length()-1)); 
		 } 
	}
		///////////////////BONUS END/////////////////////
		
	public static void main(String[] args) 
	{

		List<String> sorted_lines = Reading("unsorted.txt");
		Sort(sorted_lines);
		////////////////BONUS START HERE/////////////////
		System.out.println(" ");
		Scanner sc = new Scanner(System.in);
        while(true) 
        {
        	System.out.println("Enter any word to check if it's palindrome or not : ");
        	String x = sc.nextLine();
        	if(x.contains("STOP"))
        	{
        		System.exit(0);
        	}
        	if(isPalindrome(x)) 
        	{
        		System.out.println(x + " is a palindrome");
        		System.out.println(" ");
        	}
        	else 
        	{
        		System.out.println(x + " isn't a palindrome");
        		System.out.println(" ");
        	}

        }
	}
	///////////////////BONUS END/////////////////////
}