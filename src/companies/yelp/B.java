package companies.yelp;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// public B (int x) : B(x){}

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		HashMap<Integer, Integer> vector1 = new HashMap();
		HashMap<Integer, Integer> vector2 = new HashMap();

		for (int i = 0; i < n; i++) {
			vector1.put(in.nextInt(), in.nextInt());
		}
		for (int i = 0; i < m; i++) {
			vector2.put(in.nextInt(), in.nextInt());
		}

		int dotproduct = 0;
		for (Entry<Integer, Integer> item : vector1.entrySet()) {
			int x = item.getValue();

			if (vector2.containsKey(item.getKey())) {
				dotproduct += x * vector2.get(item.getKey());
			}
		}
	}

}