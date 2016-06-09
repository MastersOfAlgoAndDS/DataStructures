package companies.indeed;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

	public static void main(String args[]) throws Exception {
		// input
		// 3
		// 3
		// 7 2
		// 6 2
		// 5 2
		TreeMap<Long, Long> trial = new TreeMap<Long, Long>();
		for (long i = 0; i < 100000; i++) {
			trial.put(i, i);
		}

		for (Entry<Long, Long> iter : trial.entrySet()) {
			System.out.println(iter.getKey());
		}
		Scanner in = new Scanner(System.in);
		long Q = in.nextLong();
		long M = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int length = 0;
		for (int i = 0; i < M; i++) {
			int key = in.nextInt();
			int value = in.nextInt();
			map.put(key, value);
			length += value;
		}

		for (int i = 1; i < Q; i++) {
			long quantile = (int) Math.ceil(length * i / Q);
			long indexTrav = 0;
			Set<Integer> mapKeySet = map.keySet();
			long currKey = -1;
			for (Integer integer : mapKeySet) {
				if (indexTrav < quantile) {
					indexTrav += map.get(integer);
					currKey = integer;
				}
			}
			System.out.println(currKey);
		}

	}
}
