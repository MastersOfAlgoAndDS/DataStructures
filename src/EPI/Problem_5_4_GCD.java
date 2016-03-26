/**
 * Problem 5.4 : Design an ecient algorithm for computing the GCD of two numbers
 * without using multiplication, division or the modulus operators.
 * */
package EPI;

public class Problem_5_4_GCD {

	/**
	 * 
	 * Simple logic: Keep moding the numbers as (large mod small) until the mod
	 * answer is zero. when mod is zero, smaller number is the answer.
	 * 
	 * @param x
	 * @param y
	 * @return
	 * 
	 * 
	 */
	public int simpleGCD(int x, int y) {
		int z = x;
		if (x < y) {
			// since x is smaller than y, swap x and y.
			x = x ^ y;
			y = x ^ y;
			x = x ^ y;
			// z = x;
		}
		if (y == 0) {
			return z;
		}
		while (x % y != 0) {
			z = x % y;
			x = y;
			y = z;
		}
		return z;
	}

	/**
	 * Here we have an even odd logic. If any of the number is even divide that
	 * number by 2. by bit operations. And make a recursive call with new number
	 * and other number. If both the numbers are odd then make a recursive call
	 * by passing difference as the larger argument.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int recursiveGCD(int x, int y) {
		if (x == 0)
			return y;
		else if (y == 0)
			return x;
		else if ((x & 1) == 0 && (y & 1) == 0) // x and y both even
			return recursiveGCD(x >> 1, y >> 1) << 1;
		else if ((x & 1) == 0 && (y & 1) == 1) // x even but y odd
			return recursiveGCD(x >> 1, y);
		else if ((x & 1) == 1 && (y & 1) == 0) // x is odd but y is even
			return recursiveGCD(x, y >> 1);
		else if (x > y) // both x and y are odd and x is greater
			return recursiveGCD(x - y, y);
		// both x and y are odd and y is greater
		// if y>x
		return recursiveGCD(x, y - x);
	}

	public static void main(String[] args) {
		Problem_5_4_GCD p = new Problem_5_4_GCD();
		System.out.println(p.simpleGCD(16, 32));
		System.out.println(p.recursiveGCD(16, 32));
	}

}
