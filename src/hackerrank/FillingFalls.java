/*
 * https://www.hackerrank.com/challenges/filling-jars
 * */

package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class FillingFalls {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 
		long n = in.nextInt();
		long m = in.nextInt();
		long totalCandies = 0;
		for(long i=0; i<m; i++){
			long a = in.nextInt();
			long b = in.nextInt();
			long k = in.nextInt();
			totalCandies += (b-a+1) * k;
		}
		long res = totalCandies/n;
		System.out.println(res);
	}
}
