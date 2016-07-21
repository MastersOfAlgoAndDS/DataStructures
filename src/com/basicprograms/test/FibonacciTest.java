/**
 * 
 */
package com.basicprograms.test;

import org.junit.Test;

import com.basicprograms.Fibonacci;

/**
 * @author Milind
 *
 */
public class FibonacciTest {

	/**
	 * Test method for {@link com.basicprograms.Fibonacci#fibIterative(int)}.
	 */
	@Test
	public void testFibIterative() throws Exception {
		Fibonacci.fibIterative(11);
	}

	/**
	 * Test method for {@link com.basicprograms.Fibonacci#fibRecursive(int)}.
	 */
	@Test
	public void testFibRecursive() throws Exception {
		System.out.println(Fibonacci.fibRecursive(11));
	}

	/**
	 * Test method for
	 * {@link com.basicprograms.Fibonacci#fibRecursiveOptimized(int, int[])}.
	 */
	@Test
	public void testFibRecursiveOptimized() throws Exception {
		System.out.println(Fibonacci.fibRecursiveOptimized(11, new int[11]));
	}

}
