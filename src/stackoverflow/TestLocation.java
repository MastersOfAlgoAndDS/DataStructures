package stackoverflow;

import java.util.Scanner;

public class TestLocation {

	public static void main(String[] args) 
	{
		Location mylocation;
		int row; 
		int column;
		double [][] numArray; //we can leave this blank
		Scanner Reading = new Scanner(System.in);
		
		System.out.println(" How many rows will you be entering?");
		row = Reading.nextInt(); //nextInt -what it reads will convert into a integer
		
		System.out.println(" How many columns will you be entering?");
		column = Reading.nextInt();
		
		numArray = new double [row][column];
		
		System.out.println("Enter the array please");
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				numArray[i][j] = Reading.nextDouble();
				//i is the row and j is the column
			
			}
			
		}
		mylocation = locateLargest(numArray);
		
		int temp = (int)mylocation.maxValue; //this is to print out the difference between int and double(decimal)
		if (temp == mylocation.maxValue)
			System.out.println("Highest Number: " +(int)mylocation.maxValue); //(int forces to be an integer then the double it was, eliminate decimal places)
		else
			System.out.println("Highest Number: " +mylocation.maxValue); //print out with decimal
		System.out.println("Position: (" + mylocation.row+", " + mylocation.column +")");
		
		
		Reading.close();
	}
	
	
	
public static Location locateLargest(double[][] a)
		
		{
			
			Location mylocation = new Location(); //this is where we are going to store my information in
			mylocation.maxValue = a[0][0]; //this is the max value to the first number
			mylocation.row = 0;
			mylocation.column = 0;
			
			for (int i = 0; i < a.length; i++) //Length of the row; how many row there are
			{
				for (int j = 0; j < a[0].length; j++) //Length of a row; how many column in that row
					//we added array here in the second because we want of get the length of the second dimension
					//.length get the length of the current dimension , so a.length get the length of the first dimension
				{
					if (mylocation.maxValue < a[i][j] )
					{
						mylocation.maxValue = a[i][j];
						mylocation.row = i;
						mylocation.column = j;
					}
					
				}
				
			}
			
			return mylocation; 
			
		}

}