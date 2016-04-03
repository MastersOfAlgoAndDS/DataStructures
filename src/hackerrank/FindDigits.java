/**
 * 
 * Given an integer, N, traverse its digits (d1,d2,...,dn) and determine how many digits evenly divide N (i.e.: count the number of times N divided by each digit di has a remainder of 0). Print the number of evenly divisible digits.

 * Note: Each digit is considered to be unique, so each occurrence of the same evenly divisible digit should be counted (i.e.: for N=111, the answer is 3).
 * 
 * Input Format:
 * 
 * The first line is an integer, T, indicating the number of test cases. 
 * The T subsequent lines each contain an integer, N.
 * 
 * Constraints:
 * 1<=T<=15
 * 0<N<10^9
 * 
 * Output Format:
 * 
 * For every test case, count and print (on a new line) the number of digits in NN that are able to evenly divide NN.
 * 
 * Sample Input
 * 
 * 2
 * 12
 * 1012
 * Sample Output
 * 
 * 2
 * 3
 * Explanation
 * 
 * The number 12 is broken into two digits, 1 and 2. When 12 is divided by either of those digits, the calculation's remainder is 0; thus, the number of evenly-divisible digits in 12 is 2.
 * 
 * The number 10121012 is broken into four digits, 1, 0, 1, and 2. 1012 is evenly divisible by its digits 1, 1, and 2, but it is not divisible by 0 as division by zero is undefined; thus, our count of evenly divisible digits is 3.
 *  
 * 
 * */

package hackerrank;

import java.util.Scanner;

/**
 * @author Milind
 * @Problem: https://www.hackerrank.com/challenges/find-digits
 * @Solution: Read through each digit in the number and check whether it is
 *            divisible by the number. If divisible, increment counter. For
 *            reading each digit use the remainder logic to get the right most
 *            digit until the numberCopy becomes zero.
 *
 */
public class FindDigits {

	public static int findDigits(int number) {
		int count = 0;
		int numberCopy = number;
		while (numberCopy > 0) {
			int digit = numberCopy % 10;
			numberCopy = numberCopy / 10;
			if (digit == 0)
				continue;
			else {
				if (number % digit == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(findDigits(n));
		}
	}
}
