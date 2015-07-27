package geeksforgeeks.bitmagic;

public class Parity {

	/**
	 * Basically parity is number of 1s in the binary representation of a number
	 * So you can either keep finding the mod of the number and counting the number of 1s
	 * or 
	 * You can also use bitwise AND operator and right shift >> operator
	 * @param num
	 * @return
	 */
	public static int Parity(int num){
		int result = 0;
		while(num>0){
			num = num & (num - 1);
			if(result==0)
				result=1;
			else
				result=0;
		}
		return result;
			
	}
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++)
			System.out.println(i + ": " + Parity(i));
	}

}
