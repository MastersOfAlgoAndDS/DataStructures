package google;

import java.util.Arrays;

/**
 * To find the largest possible number after duplicating any of the digits in
 * the given number X
 * 
 * @author Milind
 *
 */
class LargeNumPostDuplicate {

	public int solution(int X) {
		String num = Integer.toString(X);
		char[] numArray = num.toCharArray();
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < num.toCharArray().length; i++) {
			int currVal = Integer.valueOf(Integer.toString(numArray[i]));
			currVal -= 48;
			if (max < currVal) {
				max = currVal;
				maxIndex = i;
			}
		}
		String part1 = num.substring(0, maxIndex);
		String part2 = num.substring(maxIndex);
		String ans = part1 + String.valueOf(max) + part2;
		return Integer.valueOf(ans);
	}

	public static void main(String[] args) {
		int X = 12511;
		LargeNumPostDuplicate s = new LargeNumPostDuplicate();
		System.out.println(s.solution(X));
	}
}