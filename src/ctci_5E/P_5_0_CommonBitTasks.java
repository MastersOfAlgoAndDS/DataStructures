package ctci_5E;

/**
 * @Problem: Cover the common bit tasks like Get, Set, Clear, Update a bit
 * 
 * @author Milind
 *
 */
public class P_5_0_CommonBitTasks {
	/**
	 * To get i th bit from the binary representation of the integer num We AND
	 * the number with 2^i and get a result. If the result is zero, ith bit was
	 * actually zero else it was 1.
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public static boolean getBit(int num, int i) {
		int mask = 1 << i;
		int result = num & mask;
		return result != 0;
		// return ((num & (1<<i)) !=0)
	}

	/**
	 * To set the ith bit with 1 and return the newly formed number
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public static int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
		// return num | (1 << i);
	}

	/**
	 * To clear the ith bit in binary representation of the interger num and
	 * return the newly formed number.
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public static int clearBit(int num, int i) {
		int mask = 1 << i;
		mask = ~mask;
		return num & mask;
		// return (num & ~(1<<i));
	}

	/**
	 * 
	 * To clear the bits from MSB to ith bit inclusive in binary representation
	 * of the interger num and return the newly formed number.
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public static int clearBitsMSBThroughI(int num, int i) {
		int mask = 1 << i;
		mask = mask - 1;
		return num & mask;
		// return num & ((1<<i) - 1);
	}

	/**
	 * * To clear the bits from LSB to ith bit inclusive in binary
	 * representation of the interger num and return the newly formed number.
	 * 
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public static int clearBitsLSBThroughI(int num, int i) {
		int mask = 1 << (i + 1);
		mask = mask - 1;
		mask = ~mask;
		return num & mask;
		// return num & ~((1<<(i+1)) - 1);
	}

	public static int updateBit(int num, int i, int v) {
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}
}
