package ctci_5E;

/**
 * @Problem: Write a function to determine the number of bits required to
 *           convert integer A to integer B.
 * 
 * @Solution: XOR the two numbers. Because basically we just need to see the
 *            bits which are off. i.e. 0s need to be changed to 1 or 1s need to
 *            be changed to zero should be counted.
 * 
 *            XOR will give us a number with 1s in its bits. and then counting
 *            the number of 1s will give us the answer.
 * 
 * 
 * @author Milind
 *
 */

public class P5_5_BitsRequiredToConvert {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	/**
	 * My modification to this approach.
	 * 
	 * Runtime: O(1) for 32 bit number
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int myBitSwapRequired(int a, int b) {
		int count = 0;
		int c = a ^ b;
		while (c != 0) {
			if ((c & 1) == 1)
				count++;
			c >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int num1 = 6;
		int num2 = 9;
		System.out.println(bitSwapRequired(num1, num2));
		System.out.println(myBitSwapRequired(num2, num1));

	}
}
