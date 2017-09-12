package com.basicprograms;

// headers MUST be above the first class

// one class needs to have a main() method
public class HelloWorld {
	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		String abc = "Hello";
		String xyz = "Hello";
		String pqr = new String("Hello");
		String lmn = new String("Hello");
		System.out.println(abc == xyz);
		System.out.println(abc == pqr);
		System.out.println(abc == lmn);
		System.out.println(pqr == lmn);
		// System.out.println(String.equals(abc,pqr);
		System.out.println(Integer.toHexString(abc.hashCode()));
		System.out.println(Integer.toHexString(pqr.hashCode()));
	}

}