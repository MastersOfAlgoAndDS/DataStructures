package ctci_5E;

/**
 * @Problem: Given a positive integer, print the next smallest and the next
 *           largest number that have the same number of 7 bits in their binary
 *           representation.
 * 
 * @Solution: Getting next largest -
 * 
 *            0. Count number of 1s and 0s to the right of the first
 *            non-trailing zero.
 * 
 *            1. Flip first non-trailing zero to 1 i.e. make the rightmost zero
 *            (that has one to its right) to one.
 * 
 *            2. clear bits to the right of non-trailing zero.
 * 
 *            3. set the rightmost c1-1 bits. c1-1 because number of 1s should
 *            be constant, and we created a 1 by setting non-trailing zero to 1.
 *
 * 
 *            Getting next smallest
 * 
 *            0. Count number of 1s and 0s to the right of the first
 *            non-trailing 1.
 * 
 *            1. Flip the first non-trailing one to zero.
 * 
 *            2. clear the bits to the right of non-trailing zero
 * 
 *            3. set the left most c1+1 bits to the right of non-trailing one
 *            i.e. position p (which was set to zero) to 1.
 * 
 * 
 * @author Milind
 *
 */
public class P5_3_NextSmallestLargest {
	public static int getNext(int num) {
		int c0 = 0, c1 = 0;
		int c = num;

		// Step 0
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c = c >> 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if (c1 + c0 == 31 || c1 + c0 == 0) {
			return -1;
		}

		int p = c1 + c0;

		// Step 1
		num |= (1 << p);

		// Step 2
		num &= ~((1 << p) - 1);

		// Step 3
		num |= (1 << (c1 - 1)) - 1;

		return num;
	}

	public static int getPrev(int num) {
		int c1 = 0, c0 = 0;
		int temp = num;

		// Step 0
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		// safety check
		if (temp == 0)
			return -1;

		while ((temp & 1) == 0 && temp != 0) {
			c0++;
			temp >>= 1;
		}

		int p = c1 + c0;

		// Step 1 and 2
		num &= (~(0) << (p + 1));

		// Step 3
		int mask = (1 << (c1 + 1)) - 1;
		mask = mask << (c0 - 1);
		num |= mask;

		return num;
	}

	public static void main(String[] args) {
		int num = 11;
		System.out.println(getNext(num));
		System.out.println(getPrev(num));
		num = 5;
		System.out.println(getNext(num));
		System.out.println(getPrev(num));
	}
}
