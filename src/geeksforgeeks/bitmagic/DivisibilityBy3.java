package geeksforgeeks.bitmagic;

/**
 * @author Milind
 *
 */
public class DivisibilityBy3 {

	
	/**
	 * If the remainder after dividing by 3 is zero, then the number is divisible by 3 
	 * and the number is thus a multiple of 3.
	 * 
	 * @param num
	 * @return
	 */
	public static boolean DivisibilityBy3_Traditional(int num){
		if(num%3==0)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<25; i++)
			System.out.println(i + ": " + DivisibilityBy3_Traditional(i));
	}

}
