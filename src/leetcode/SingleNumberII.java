package leetcode;

public class SingleNumberII {

	public static int singleNumber(int[] nums){
//		int len = nums.length;
//		int sum = 0;
//		int oddElemCnt = 3 - len % 3;
//		for(int i : nums)
//			sum+=i;
//		int oddElemSum = 3 - sum % 3;
//		int result = oddElemSum / oddElemCnt;
//		return result;
		
		int ones=0, twos=0, threes=0;
		for(int i : nums)
		{
			System.out.println(i);
			twos |= ones & i;
			ones ^= i;
			threes = ones & twos;
			
			System.out.println("ones: " + ones + " twos: " + twos + " threes:" + threes);
			
			ones &= ~threes;
			twos &= ~threes;
			System.out.println("ones: " + ones + " twos: " + twos + " threes:" + threes);
			
		}
		
		return ones;
		
	}
	
	public static int singleNumber_XORApproach(int[] nums){
		int temp = 0;
		int sum = 0;
		for(int i : nums){
			System.out.print("XORing: " + i + " XOR " + temp);
			sum+=i;
			temp = temp ^ sum;
			System.out.println(" temp: " + temp);
		}
		System.out.println("sum: " + sum);
		System.out.println("temp: " + temp);
		System.out.println("sum XOR temp: " + (sum ^ temp));
		int result = (3 * temp - sum) / 2;
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,4,1,2,2,2,1};
		//System.out.println(singleNumber_XORApproach(arr));
		singleNumber_XORApproach(arr);
	}

}
