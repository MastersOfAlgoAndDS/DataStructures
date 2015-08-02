/**
 * EPI book
 * Problem 5.1 : How would you go about computing the parity of a very large number
 * of 64-bit nonnegative integers?
 * Parity is number of 1s in the binary representation of a number. 
 * If there are even number of 1s then the parity is 0
 * If there are odd number of 1s then the parity is 1
 * Ans : pg 112
 * 
 * */

package EPI;

/**
 * @author Milind
 *
 */
public class Problem_5_1 {

	/**
	 * 	basically we're shifting 1 bit right each time 
	 *  and checking whether the rightmost bit of the binary number is 1 or 0
	 *  and we make use of the following properties of XOR (i.e. ^)
	 *  	1 XOR 1 = 0
	 *  	1 XOR 0 = 1
	 *  So if there are even 1s, the XOR and hence the parity becomes 0 automatically
	 *   
	 * @param x
	 * @return
	 */
	public static short parity (long x){
		short result = 0;
		while(x>0){
			result ^= (x & 1);
			x >>=1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Some trials");
		int x = 4;
		//the binary representation
//		System.out.println(x);
//		System.out.println(Utilities.decToBin(x));
//		System.out.println(x << 1);
//		System.out.println(Utilities.decToBin(x << 1));
//		System.out.println(x>>1);
//		System.out.println(Utilities.decToBin(x>>1));
//		
//		System.out.println(parity(x));
//		
//		System.out.println(Utilities.decToBin(4));
//		System.out.println(Utilities.decToBin(1));
//		System.out.println(5 & 1);
		
		for(int i=0; i<20; i++)
			System.out.println("parity of " + i + " is: "  + parity(i));
	}

}

