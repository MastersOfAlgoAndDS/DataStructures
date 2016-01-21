package EPI;

import java.util.Arrays;
import java.util.LinkedList;

import com.ds.Node;

public class Utilities {

	public static String decToBin(int n) {
		String result = "";
		if (n == 0)
			return "0";
		while (n > 0) {
			result = n % 2 + result;
			n = n / 2;
		}
		return result;
	}

	public static int binToDec(String bin) {
		int result = 0;
		for (int i = bin.length() - 1; i >= 0; i--) {
			result += Math.pow(2, bin.length() - 1 - i) * (bin.charAt(i) - 48);
		}
		return result;
	}

	public static int getIntValue(char c) throws Exception {
		if (c >= '0' && c <= '9')
			return c - 48;
		else
			throw new Exception("Not an integer");
	}

	public static int getAsciiValue(char c) {
		return c;
	}

	public static LinkedList<String> getLinkedListFromArray(String[] array) {
		LinkedList<String> ll = new LinkedList<String>(Arrays.asList(array));
		return ll;
	}

	public static void main(String[] args) {
		int num = 64;
		System.out.println(decToBin(124 >> 3));
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
