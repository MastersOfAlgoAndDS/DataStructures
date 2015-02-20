package hackerrank;

import java.util.Scanner;

public class MaxXor {
	static int maxXor(int l, int r) {
		int res = 0;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				if ((i ^ j) > res)
					res = i ^ j;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = in.nextInt();

		int _r;
		_r = in.nextInt();

		res = maxXor(_l, _r);
		System.out.println(res);
	}
}
