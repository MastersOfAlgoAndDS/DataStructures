package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Utilities {

	/**
	 * 
	 * This function converts decimal number to binary
	 * 
	 * @Logic: While the input number is greater than zero, keep appending the
	 *         remainder of number/2.
	 * 
	 * @param n
	 * @return
	 */
	public static String decToBin(int n) {
		StringBuilder result = new StringBuilder();
		if (n == 0)
			return "0";
		while (n > 0) {
			result.append(n % 2);
			n = n / 2;
		}
		return result.reverse().toString();
	}

	/**
	 * 
	 * This function converts a binary number input to decimal
	 * 
	 * @Logic: Fetch each number starting from LSB and multiply by respective
	 *         power of 2 and add to the result.
	 * 
	 * @param bin
	 * @return
	 */
	public static int binToDec(String bin) {
		int result = 0;
		for (int i = bin.length() - 1; i >= 0; i--) {
			result += Math.pow(2, bin.length() - 1 - i) * (bin.charAt(i) - 48);
		}
		return result;
	}

	/**
	 * This function converts a character to integer. Only numbers 0 to 9 are
	 * converted. Otherwise Not an Integer exception message is given.
	 * 
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public static int getIntValue(char c) throws Exception {
		if (c >= '0' && c <= '9')
			return c - 48;
		else
			throw new Exception("Not an integer");
	}

	/**
	 * This function Gives the ASCII value of the given character
	 * 
	 * @param c
	 * @return
	 */
	public static int getAsciiValue(char c) {
		return c;
	}

	/**
	 * This function converts a given array to LinkedList
	 * 
	 * @param <T>
	 * 
	 * @param array
	 * @return
	 */
	public static <T> LinkedList<T> getLinkedListFromArray(T[] array) {
		LinkedList<T> ll = new LinkedList<T>(Arrays.asList(array));
		return ll;
	}

	/**
	 * 
	 * Function to get ArrayList from array
	 * 
	 * @param array
	 * @return
	 */
	public static <T> ArrayList<T> getArrayListFromArray(T[] array) {
		ArrayList<T> list = new ArrayList<T>();
		for (T object : array) {
			list.add(object);
		}
		return list;
	}

	public static void main(String[] args) {
		int num = 64;
		System.out.println(decToBin(7));
		System.out.println(binToDec("0110010"));

		for (char i = 65; i <= 90; i++) {
			System.out.println(i + ": " + binToDec(decToBin(i)));
		}
		System.out.println();
		for (char i = 97; i <= 122; i++) {
			System.out.println(i + ": " + binToDec(decToBin(i)));
		}

		for (char i = '0'; i <= '9'; i++) {
			System.out.println(i);
		}

		System.out.println(decToBin('H'));

		System.out.println(getAsciiValue('0'));
		System.out.println(getAsciiValue('A'));
		System.out.println(getAsciiValue('a'));
		try {
			System.out.println(getIntValue('8'));
			System.out.println(getIntValue('A'));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getListLength(Node head) {
		Node trav = head;
		int count = 0;
		while (trav != null) {
			count++;
			trav = trav.getNext();
		}
		return count;
	}

}
