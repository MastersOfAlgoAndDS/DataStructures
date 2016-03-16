package yelp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Milind
 * @Problem: Given two sparse Vectors, compute the Dot Product. Input Format :
 *           The first line will contain two numbers(k and n), which are the
 *           number of entries for the two vectors respectively. The next k
 *           lines are the entries for the first vector, of the form : x y where
 *           x is the position and y is the value at that position in the
 *           vector. The n lines are the entries of the second vector. Any
 *           entries not specified indicate zero at that position. The two
 *           vectors will always be of the same length
 * 
 *           Example input: 3 3 1 4 4 2 5 3 1 7 2 6 5 1
 * 
 *           Sample Answer: Dot Product = 4*7+3*1 = 31 (only print 31)
 * 
 * @Solution: Use 1 hashmap. Read the first vector in the hashmap and then while
 *            reading second vector in the hashmap, multiply and store the value
 *            in the hashmap. Read only the values which are already present in
 *            the hashmap because the product for other values in second vector
 *            are going to be 0 since there are not corresponding values at
 *            those indices in the first vector.
 *
 */
public class VectorDotProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		// Get the size of the first and second vector
		int size1 = Integer.valueOf(line.split(" ")[0]);
		int size2 = Integer.valueOf(line.split(" ")[1]);

		// Get the vector 1
		HashMap<Integer, Integer> dotProduct = new HashMap<Integer, Integer>();
		for (int i = 0; i < size1; i++) {
			String vector1 = in.nextLine();
			int index1 = Integer.valueOf(vector1.split(" ")[0]);
			int value1 = Integer.valueOf(vector1.split(" ")[1]);
			dotProduct.put(index1, value1);
		}

		// Get the vector 2
		int productAns = 0;
		for (int i = 0; i < size2; i++) {
			String vector2 = in.nextLine();
			int index2 = Integer.valueOf(vector2.split(" ")[0]);
			int value2 = Integer.valueOf(vector2.split(" ")[1]);
			if (dotProduct.containsKey(index2)) {
				dotProduct.put(index2, dotProduct.get(index2) * value2);
				productAns += dotProduct.get(index2);
			}
		}

		in.close();

		System.out.println("Dot Product: " + productAns);
	}
}
