/**
 * Problem 5.3 : Implement string/integer inter-conversion functions. Use the following
 * function signatures: String intToString(int x) and int stringToInt(String s).
 * 
 * */

package EPI;

public class Problem_5_3_int_String_interconvert {

	public String intToString(int x) {
		String result = "";
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		} else {
			isNegative = false;
		}

		while (x > 0) {
			result = (x % 10) + result;
			x = x / 10;
		}

		if (isNegative)
			return "-" + result;
		return result;
	}

	public int stringToInt(String str) throws Exception {
		int result = 0;
		if (str == "-")
			throw new Exception("Illegal input");
		boolean isNegative = false;
		if (str.charAt(0) == '-') {
			isNegative = true;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			isNegative = false;
			str = str.substring(1);
		}

		for (char c : str.toCharArray()) {
			if (isDigit(c)) {
				// substracting 48 because in ascii characters the number 0 is
				// 48.
				// so subtracting the offsetr value 48 to get the integer value
				// 0 and so on.
				result = result * 10 + c - 48;
			}
		}
		return isNegative ? -result : result;
	}

	/**
	 * Return whether the given character is digit or not Here we use the ASCII
	 * value to determine whether the character is digit or not
	 * 
	 * @return
	 */
	public boolean isDigit(char character) {
		if ((character >= '0' && character <= '9') || character == '+'
				|| character == '-') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Problem_5_3_int_String_interconvert p = new Problem_5_3_int_String_interconvert();
		String answer = p.intToString(-123);
		System.out.println(answer);
		try {
			int ans = p.stringToInt("+123");
			System.out.println(ans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
