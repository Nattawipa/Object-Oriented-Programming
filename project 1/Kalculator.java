//Name: Nattawipa Saetae
//ID:6188089
//Section:1


public class Kalculator  
{
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	
	public double number;
	public double[] all;
	public static int length;
	public static double sum;
	public static double avg;
	public static double max;
	public static double min;
	public static double[] temparr;
	
	//**************************************
	
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		
		all = new double[100];
		length = 0;
		sum = 0;
		avg = 0;
		
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{
		//******INSERT YOUR CODE HERE***********
		
		all[length] = number;    //count amount of number
			length++;
			
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		
		if (length > 0)     //delete first number then move the other replace the first block  
		{
			for (int i=0;i<length;i++) 
			{
				all[i]=all[i+1];
			}
			length--;
		}
		
		//**************************************
	}
	
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		
		if (length > 0)  //delete last number and delete the last block
		{
			all[length-1] = 0;
			length--;
		}
		
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		
		int i;
		if (length == 0)
		{
			return 0;
		}
		for (i=0; i<length; i++ )
		{
			sum = sum + all[i]; 
		}
		return sum;
		
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		
		if (length == 0)
		{
			return 0;
		}
		avg = sum/length;
		return avg;
		
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		
		double std=0;    //use the formula to find standard deviation
		if(length < 2)
		{
			return 0;
		}
		for(int i = 0 ; i < length ; i++)
		{
			std = std + Math.pow((all[i] - avg),2);
		}
		return  Math.sqrt(std/(length-1));
		
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		
		max = all[0];      //check the number one by one with the next number then keep the max number in one variable
		if (length == 0)
		{
			return 0;
		}
		for (int i = 0; i < length; i++)
		{
			if(all[i] > max)
			{
				max = all[i];
			}
		}
		return max;
		
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		
		min = all[0];       //check number one by one with the next number if which one is smallest then keep it in one variable
		if (length==0)
		{
			return 0;
		}
		for (int i=0 ; i < length ; i++)
		{
			if(min > all[i])
			{
				min = all[i];
			}
		}
		return min;
		
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		
		double[] maxk;				
		maxk = new double[k];
		temparr = all.clone();
		
		if (length <= k)
		{
			return null;
		}
		       
		for (int i = 0; i <length-1; i++)    //use bubble sort to order the number from left to right (smallest to biggest) 
		{
			for (int j = 0; j <length-i-1; j++)      //max number keeping from right to left 
		    if (temparr[j] > temparr[j+1]) 
		    { 
		    	// swap all[j+1] and all[i] 
		        double temp = temparr[j]; 
		        temparr[j] = temparr[j+1]; 
		        temparr[j+1] = temp; 
		    }
		}
		        
		for (int i=0;i<k; i++)
		{
			maxk[i] = temparr[length-i-1];
		}
		return maxk;
	
 		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		
		double[] mink; 				//use number from bubble sort and let keeping min number from left to right 
		mink = new double[k];
		if (length <= k)
		{
			return null;
		}
		        for (int i=0;i<k; i++)
		        {
		        	mink[i] = temparr[i];
		        }
		        return mink;
		        
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		
		if(length < 0) 
		{
			length = 0;
		}
		
		System.out.print("DATA["+length+"] : [");
		
		for(int i=0;i<length;i++) 
		{
			if(i==length-1) 
			{
				System.out.print(all[i]);
			}
			else 
			{
				System.out.print(all[i]+", ");
			}
		}
		System.out.println("]");
		
		//**************************************
	}
}
