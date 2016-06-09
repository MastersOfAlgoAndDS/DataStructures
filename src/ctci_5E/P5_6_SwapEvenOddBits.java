package ctci_5E;

import com.ds.Utilities;

/**
 * 
 * @Problem: Write a program to swap odd and even bits in an integer with as few
 *           instructions as possible (e.g., bit 0 and bit! are swapped, bit 2
 *           and bit 3 are swapped, and so on).
 *
 * @Solution: 1. create a mask - get all odd bits and shift right.
 * 
 *            2. Create a mask - Get all even bits and shift left.
 * 
 *            3. OR these two masks and you get the answer.
 * 
 *            Example: 5 when swapped with this should give 10 and 7 when
 *            swapped with this should give 11
 * 
 * @author Milind
 *
 */
public class P5_6_SwapEvenOddBits {
	public static int swapEvenOffBits(int num) {
		int maskEven = Utilities.binToDec("10101010101010101010101010101010");
		int maskOdd = Utilities.binToDec("01010101010101010101010101010101");

		// technically maskEven is 0xaaaaaaaa and maskOdd is 0x55555555

		maskEven = (num & maskEven) >> 1;
		maskOdd = (num & maskOdd) << 1;
		return (maskEven | maskOdd);
	}

	public static void main(String[] args) {
		System.out.println(swapEvenOffBits(5));
		System.out.println(swapEvenOffBits(7));
	}
}
