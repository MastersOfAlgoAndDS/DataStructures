package com.basicprograms;
import java.io.IOException;
import java.util.Scanner;

public class SumOfIntegers {

	static long sumOfIntegers(int[] arr) {
		long sum = 0;
		for (long i : arr) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		long res;

		int _arr_size = 0;
		_arr_size = Integer.parseInt(in.nextLine().trim());
		int[] _arr = new int[_arr_size];
		int _arr_item;
		for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
			_arr_item = Integer.parseInt(in.nextLine().trim());
			_arr[_arr_i] = _arr_item;
		}

		res = sumOfIntegers(_arr);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
		System.out.println(res);
	}

}
