package ctci_5E;

/**
 * @Problem: Given a real number between 0 and 7 (e.g., 0.72) that is passed in
 *           as a double, print the binary representation. If the number cannot
 *           be represented accurately in binary with at most 32 characters,
 *           print "ERROR."
 * 
 * @Solution: 2 approaches
 * 
 *            1. Either handle it in binary completely. So keep multiplying the
 *            number by 2 to get first bit after dot point to the left of dot
 *            point in binary. and then check whether that is greater than 1 or
 *            less than 1
 * 
 *            2. Handle it by comparing the num with 0.5 then with 0.25 then
 *            with 0.125 and so on. and everytime num it is greater than the
 *            compared number like 0.5 or 0.25 then put binary 1 else put binary
 *            0.
 * 
 * @author Milind
 *
 */
public class P5_2_RepresentRealToBinary {

	/**
	 * Approach 1. Based on the binary representation and bit shifting.
	 * 
	 * @param num
	 * @return
	 */
	public static String realToBin(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			if (binary.length() >= 32)
				return "ERROR";
			double r = num * 2;
			if (r >= 1) {
				binary.append("1");
				num = r - 1;
			} else {
				binary.append("0");
				num = r;
			}
		}
		return binary.toString();
	}

	/**
	 * Approach 2. Baed on the comparisons with the decimal numbers like 0.5,
	 * 0.25, 0.125
	 * 
	 * @param num
	 * @return
	 */
	public static String realToBin2(double num) {
		if (num >= 1 || num <= 0)
			return "ERROR";

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		double frac = 0.5;
		while (num > 0) {
			if (binary.length() >= 32)
				return "ERROR";
			if (num >= frac) {
				binary.append("1");
				num = num - frac;
			} else {
				binary.append("0");
			}
			frac = frac / 2;
		}
		return binary.toString();
	}

	public static void main(String[] args) {
		System.out.println(realToBin(0.125));
		System.out.println(realToBin2(0.125));
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = realToBin(num);
			if (!binary.equals("ERROR")) {
				System.out.println(num + " : " + binary);
			}
		}

	}
}
