package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CutTheSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
	}

	public static ArrayList<Integer> cutTheSticks(int[] input) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < input.length; i++) {
			list.add(input[i]);
			if (map.containsKey(input[i])) { // update entry in map
				map.get(input[i]).add(i);
			} else { // make entry in map
				ArrayList<Integer> value = new ArrayList<Integer>();
				value.add(i);
				map.put(input[i], value);
			}
		}

		while (!list.isEmpty()) {
			output.add(list.size());
			
		}

		return output;
	}
}
