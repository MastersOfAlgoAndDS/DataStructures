/**
 * To find the difference between A[x] and A[y] such that x<y and A[x] < A[y]
 * 
 * 
 * */

package VMware;

public class MaxArrayDiff {

	public static void main(String[] args) {
		int[] input = new int[5];
		input[0] = 4;
		input[1] = 6;
		input[2] = 3;
		input[3] = 8;
		input[4] = 10;
		System.out.println(kSub(2, new int[] { 0, 0 }));

	}

	static long kSub(int k, int[] nums) {
		int[] cntMod = new int[nums.length];
		cntMod[0] = 1;
		int prefSum = 0;
		for (int elem : nums) {
			prefSum += elem;
			prefSum %= k;
			cntMod[prefSum]++;
		}
		long res = 0;
		for (int mod = 0; mod < k; mod++)
			res += (long) cntMod[mod] * (cntMod[mod] - 1) / 2;
		return res;
	}

}
