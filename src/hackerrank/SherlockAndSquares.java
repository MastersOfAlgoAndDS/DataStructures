package hackerrank;

import java.util.Scanner;

public class SherlockAndSquares {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++){
			long a = in.nextInt();
			long b = in.nextInt();
			long ans = sherlockAndSquares(a,b);
			System.out.println(ans);
		}
	}

	private static long sherlockAndSquares(long a, long b) {
		long aRoot = (long) Math.ceil(Math.sqrt(a));
		long bRoot = (long) Math.floor(Math.sqrt(b));
		
		return bRoot - aRoot + 1;
	}
}
