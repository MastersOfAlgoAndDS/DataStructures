/**
 * Problem 5.4 : Design an ecient algorithm for computing the GCD of two numbers
 * without using multiplication, division or the modulus operators.
 * */
package EPI;

public class Problem_5_4 {

	/**
	 * 
	 * Simple logic: Keep moding the numbers as (large mod small) until the mod answer is zero. 
	 * when mod is zero, smaller number is the answer.
	 * @param x
	 * @param y
	 * @return
	 */
	public int simpleGCD(int x, int y) {
		int z = x;
		if (x < y) {
			//since x is smaller than y, swap x and y.
			x = x ^ y;
			y = x ^ y;
			x = x ^ y;
			z = x;
		}
		if(y == 1){
			return z;
		}
		while (x % y != 0) {
			z = x % y;
			x = y;
			y = z;
		}
		return z;
	}

	public static void main(String[] args) {
		Problem_5_4 p = new Problem_5_4();
		System.out.println(p.simpleGCD(1, 32));
	}

}
