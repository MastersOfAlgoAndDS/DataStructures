/**
 * 
 *  You are given two 32-bit numbers, N and M, and two bit positions, land j. Write
 *  a method to insert M into N such that M starts at bit j and ends at bit i. You can
 *  assume that the bits j through i have enough space to fit all of M. That is, if
 *  M = 10011, you can assume that there are at least 5 bits between j and i. You
 *  would not, for example, have j = 3 and i = 2, because M could not fully fit
 *  between bit 3 and bit 2.
 *  
 *  EXAMPLE
 *  Input: N = 10000000001, M = 10011, i = 2, j = 6
 *  Output: N = 10001001101
 * 
 * 
 * Solution: 	The best way to go about this is to use bitwise operations.
 * 				We want to basically 
 * 				1. Clear all the bits from 2 to 6. 
 * 				2. Then shift the number M so that its MSB is 6. 
 * 						i.e. it will superimpose on the number N.
 * 				3. OR the shifted M (in step 2) with the cleared N (in step 1) to get the answer
 * 
 * 
 * */

package ctci_5E;

import com.ds.Utilities;

/**
 * @author Milind
 *
 */
public class P5_1_InsertMintoN {

	public static int insertMintoN(int M, int N, int i, int j) {
		// mask can be split into two parts - left i.e. j to MSB and right i.e.
		// LSB to i
		int allOnes = ~(0);
		int left = (allOnes << (j + 1));
		int right = (1 << i) - 1;
		int mask = left | right;

		// Step 1
		int NWithClearedBits = N & mask;

		// Step 2
		int mShifted = M << i;

		// Step 3
		return NWithClearedBits | mShifted;
	}

	public static void main(String[] args) {
		int M = Utilities.binToDec("10011");
		int N = Utilities.binToDec("10000000001");
		System.out.println(M);
		System.out.println(N);
		System.out.println(insertMintoN(M, N, 2, 6));
		System.out.println(Utilities.decToBin(insertMintoN(M, N, 2, 6)));
	}
}
