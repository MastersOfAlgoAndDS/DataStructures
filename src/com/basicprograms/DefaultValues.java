package com.basicprograms;
/**
 * 
 * The wrapper class objects are by default null and primitives are by default 0
 * or false;
 * 
 * @author Milind
 *
 */
public class DefaultValues {
	public static void main(String[] args) {
		Boolean b1[] = new Boolean[10];
		boolean b2[] = new boolean[10];
		Integer[] d1 = new Integer[100];
		int[] d2 = new int[100];
		Character[] c1 = new Character[10];
		char[] c2 = new char[10];
		System.out.println("b1[1] = " + b1[1]);
		System.out.println("b2[1] = " + b2[1]);
		System.out.println("d1[1] = " + d1[1]);
		System.out.println("d2[1] = " + d2[1]);
		System.out.println("c1[1] = " + c1[1]);
		System.out.println("c2[1] = " + c2[1]);
	}
}
