package ctci_5E;

import java.util.ArrayList;

/**
 * @Problem: An array A contains all the integers from 0 through n, except for
 *           one number which is missing. In this problem, we cannot access an
 *           entire integer in A with a single operation. The elements of A are
 *           represented in binary, and the only operation we can use to access
 *           them is "fetch thejth bit ofAfi]," which takes constant time. Write
 *           code to find the missing integer. Can you do it in 0(n) time?
 *
 *           !!!! Typically can be solved by summing and finding diff with the
 *           sum of n numbers. But that is O(nlogn) while bitwise approach is
 *           O(n).
 * 
 * @Solution: We can form a small table with possible outcomes for the LSB
 * 
 *            if n % 2 == 1 then count(0s) = count(ls)
 * 
 *            if n % 2 == 0 then count(0s) = 1 + count(ls)
 * 
 *            Thus:
 * 
 *            If count(0s) <= count(ls),then LSB(v) = 0.
 * 
 *            If count(0s) > count(ls),then LSB(v) = 1.
 * 
 *            Keep moving back from LSB column 0 to MSB. and keep checking
 *            whether the number is 0. Then remove all the values which don't
 *            have LSB column value as found value (0 or 1) and Keep doing this
 *            until the arraylist is empty.
 * 
 * @author Milind
 *
 */
public class P5_7_FindMissingNumber {
	public static int findMissingNumber(ArrayList<Integer> array) {
		int result = findMissingNumber(array, 0);
		return result;
	}

	/**
	 * fetch the bit value of ith bit. 0 or 1
	 * 
	 * @param num
	 * @param i
	 * @return 0 or 1
	 * @throws Exception
	 */
	public static int fetchIthBit(int num, int i) throws Exception {
		if (i < 0)
			throw new Exception("i should be greater than or equal to 0");
		return (num >> i) & 1;
	}

	private static int findMissingNumber(ArrayList<Integer> array, int column) {
		if (column >= 32)
			return 0;
		ArrayList<Integer> oneBitNums = new ArrayList<Integer>();
		ArrayList<Integer> zeroBitNums = new ArrayList<Integer>();
		for (Integer num : array) {
			try {
				if (fetchIthBit(num, column) == 0) {
					zeroBitNums.add(num);
				} else {
					oneBitNums.add(num);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (zeroBitNums.size() <= oneBitNums.size()) // then the removed number
														// is with 0 in column
														// bit
		{
			int v = findMissingNumber(zeroBitNums, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissingNumber(oneBitNums, column + 1);
			return (v << 1) | 1;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0);
		array.add(1);
		array.add(4);
		array.add(3);
		array.add(2);
		array.add(6);
		array.add(7);
		System.out.println(findMissingNumber(array));
	}
}
