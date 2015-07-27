package geeksforgeeks.bitmagic;

public class NextPowerOf2 {

	public static int NextPowerOf2_logMethod(int num){
		Double power = Math.ceil(Math.log(num));
		//System.out.println(power);
		return (int)Math.pow(2, power+1);
	}
	
	
	/**
	 * Basically keep shifting the bits to right until the number is 0. 
	 * Meanwhile count the number of bits you needed to shift to right to make the number 0.
	 * So now the next power of two will be to shift the bit 1 to the left count number of times.
	 * This means we're getting the current power of 2 for the given number and 
	 * then multiplying it by 2. i.e. shifting the bit to left by 1 more bit 
	 * to get the next power of two for the number.
	 * 
	 * @param num
	 * @return int
	 */
	public static int NextPowerOf2_bitMethod(int num){
		int count=0;
		//if((num & (num - 1))==1) return num;
		while(num!=0){
			num >>= 1;
			count++;
		}
		return 1 << count;
	}
	
	public static int NextPowerOf2_simpleBitShift(int num){
		int p = 1;
		while(p<num)
			p <<= 1;
		if(p==num)
			return p<<1;
		return p;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<=32; i++)
			System.out.println(i + ": " + NextPowerOf2_simpleBitShift(i));
	}

}
