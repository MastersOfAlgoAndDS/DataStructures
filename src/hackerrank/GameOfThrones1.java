package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GameOfThrones1 {

	public static String gameOfThrones1(String input) {
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		char[] arr = input.toCharArray();
		int len = arr.length;
		for (char iter : arr) {
			if (hash.containsKey(iter)) {
				int val = hash.get(iter);
				//hash.replace(iter, val + 1); //got error 
				//Solution.java:16: error: 
				//cannot find symbol method replace(char,int) for this line so other option
				hash.put(iter, hash.get(iter) + 1);
			} else {
				hash.put(iter, 1);
			}
		}
		int oddCharCount = 0;
		for (char iter : hash.keySet()) {
			if (hash.get(iter) % 2 == 1)
				oddCharCount++;
		}
		if(len%2==0 && oddCharCount>0)
			return "NO";
		else if(len%2==1 && oddCharCount>1)
			return "NO";
		else return "YES";
	}

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		String ans;
		// Assign ans a value of YES or NO, depending on whether or not
		// inputString satisfies the required condition
		// System.out.println(ans);
		System.out.println(gameOfThrones1(inputString));
		myScan.close();
	}
}
