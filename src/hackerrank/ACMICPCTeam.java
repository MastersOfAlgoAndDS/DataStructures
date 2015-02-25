package hackerrank;

/*
 * https://www.hackerrank.com/challenges/acm-icpc-team
 * */

import java.util.Scanner;

public class ACMICPCTeam {

	public static void ACMICPCTeam(String[] arr, int n, int m) {
		int maxCourseCnt = 0;
		int teamCnt = 0;
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				cnt = 0;
				for (int k = 0; k < m; k++) {
					if (arr[i].charAt(k) == '1'
							| arr[j].charAt(k) == '1') {
						cnt++;
					}
				}
				if (cnt > maxCourseCnt) {
					maxCourseCnt = cnt;
					teamCnt = 1;
				} else if (cnt == maxCourseCnt) {
					teamCnt++;
				}
			}
		}

		System.out.println(maxCourseCnt);
		System.out.println(teamCnt);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// n number of members
		int n = in.nextInt();
		// m number of courses
		int m = in.nextInt();
		/*
		 * System.out.println(n); System.out.println(m);
		 */
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.next();
		}

		/*
		 * for (int i = 0; i < n; i++) { System.out.println(arr[i]); }
		 */
		ACMICPCTeam(arr, n, m);
		in.close();
	}
}
