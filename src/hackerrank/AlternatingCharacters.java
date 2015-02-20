package hackerrank;

import java.util.Scanner;

public class AlternatingCharacters {
	public static int alternatingCharacters(String inp) {
		int cnt = 0;
		char[] a = inp.toCharArray();
		char character = a[0];
		for (int i = 1; i < a.length; i++) {
			if (character == a[i])
				cnt++;
			character = a[i];
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		String val1;
		int res;
		for (int i = 0; i < t; i++) {
			String elements = in.next();
			val1 = elements;
			res = alternatingCharacters(val1);
			System.out.println(res);
		}
	}

}
