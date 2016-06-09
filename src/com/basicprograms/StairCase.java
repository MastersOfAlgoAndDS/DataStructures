package com.basicprograms;
import java.util.Scanner;

public class StairCase {

	static void StairCase(int n) {
		char[] string = new char[n];
		for (int i = 0; i < n; i++) {
			string[i] = ' ';
		}
		int i = n - 1;
		while (i >= 0) {
			string[i--] = '#';
			System.out.println(String.valueOf(string));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _n;
		_n = Integer.parseInt(in.nextLine().trim());
		StairCase(_n);
	}

}
