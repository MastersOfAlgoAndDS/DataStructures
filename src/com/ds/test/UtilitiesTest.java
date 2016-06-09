/**
 * 
 */
package com.ds.test;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import com.ds.Utilities;

/**
 * @author Milind
 *
 */
public class UtilitiesTest {

	/**
	 * Test method for {@link com.ds.Utilities#decToBin(int)}.
	 */
	@Test
	public void testDecToBin() throws Exception {
		System.out.println(Utilities.decToBin(12345));
	}

	/**
	 * Test method for {@link com.ds.Utilities#binToDec(java.lang.String)}.
	 */
	@Test
	public void testBinToDec() throws Exception {
		System.out.println(Utilities.binToDec("11000000111001"));
	}

	/**
	 * Test method for {@link com.ds.Utilities#getIntValue(char)}.
	 */
	@Test
	public void testGetIntValue() throws Exception {
		System.out.println(Utilities.getIntValue('9'));
	}

	/**
	 * Test method for {@link com.ds.Utilities#getAsciiValue(char)}.
	 */
	@Test
	public void testGetAsciiValue() throws Exception {
		System.out.println(Utilities.getAsciiValue('0'));
	}

	/**
	 * Test method for {@link com.ds.Utilities#getLinkedListFromArray(T[])}.
	 */
	@Test
	public void testGetLinkedListFromArray() throws Exception {
		String[] arr = new String[4];
		arr[0] = "Milind";
		arr[1] = "Hemant";
		arr[2] = "Gokhale";
		arr[3] = "USA";
		LinkedList<String> list = Utilities.getLinkedListFromArray(arr);
		System.out.println(list);
	}

	/**
	 * Test method for
	 * {@link com.ds.Utilities#getArrayListFromArray(java.lang.Object[])}.
	 */
	@Test
	public void testGetArrayListFromArray() throws Exception {
		Integer[] arr = new Integer[4];
		arr[0] = 0;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 6;
		ArrayList<Integer> list = Utilities.getArrayListFromArray(arr);
		System.out.println(list);

	}
}
