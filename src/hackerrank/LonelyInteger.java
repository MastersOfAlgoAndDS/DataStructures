package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import jdk.nashorn.internal.runtime.ListAdapter;

public class LonelyInteger {
	static int lonelyintegerNlogn(int[] a) {
		if (a.length == 1)
			return a[0];
		else {
			Arrays.sort(a);
			for (int i = 0; i < a.length; i++) {
				if (i != a.length - 1 && a[i] == a[i + 1]) {
					i++;
				} else {
					return a[i];
				}
			}
		}
		return 0;
	}

	static int lonelyintegerN(int[] a) {
		int[] b = new int[100];
		for(int i =0; i<b.length; i++){
			b[i] = 0;
		}
		
		for(int i=0; i<a.length; i++){
			b[a[i]]++;
		}
		
		for(int i =0; i<b.length; i++){
			if(b[i]==1){
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyintegerN(_a);
		System.out.println(res);

	}
}
