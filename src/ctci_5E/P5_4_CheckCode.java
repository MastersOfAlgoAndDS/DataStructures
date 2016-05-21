package ctci_5E;

/**
 * 
 * @Problem: What does the code in the whatDoesItDo function do?
 * 
 * @Solution: It Checks whether the number is a power of two. since it checks
 *            basically does the number have a leading 1 in the MSB or not. If
 *            the MSB is a 1 then all other bits must be zero and thus the
 *            number is a power of 2.
 * 
 * 
 * @author Milind
 *
 */
public class P5_4_CheckCode {

	public static boolean whatDoesItDo(int n) {
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println(whatDoesItDo(20));
		System.out.println(whatDoesItDo(10));
		System.out.println(whatDoesItDo(6));
		System.out.println(whatDoesItDo(7));
		System.out.println(whatDoesItDo(8));
		System.out.println(whatDoesItDo(1024));
		// Checks whether the number is a power of two. since it checkes
		// basically does the number have a leading 1 in the MSB or not.
		// If the MSB is a 1 then all other bits must be zero and thus the
		// number is a power of 2
	}
}
