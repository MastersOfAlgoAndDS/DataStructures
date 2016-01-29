package crackingthecodinginterview;

/**
 * @Problem_1_4 Write a method to replace all spaces in a string with'%20'. You
 *              may assume that the string has sufficient space at the end of
 *              the string to hold the additional characters, and that you are
 *              given the "true" length of the string. (Note: if implementing in
 *              Java, please use a character array so that you can perform this
 *              operation in place.)
 * 
 *              EXAMPLE Input: "Mr John Smith    " Output: "Mr%20Dohn%20Smith"
 *              Here we assume specifically that we have sufficient space to
 *              incorporate the characters %20 so as to do it in-place
 * 
 * @author Milind
 *
 */
public class P1_4_ReplaceSpaceWithEncode {

	private char[] input;

	public char[] getInput() {
		return input;
	}

	public void setInput(char[] input) {
		this.input = input;
	}

	public static void main(String[] args) {
		P1_4_ReplaceSpaceWithEncode s = new P1_4_ReplaceSpaceWithEncode();
		String str = "Mr John Smith    ";
		s.setInput(str.toCharArray());
		System.out.println(s.getInput());
		s.replace(s);
		System.out.println(s.getInput());

	}

	/**
	 * Here doing this function in-place in character array is very important
	 * and logic can be used in many other problems
	 * 
	 * 
	 * @param obj
	 * @return
	 */
	private void replace(P1_4_ReplaceSpaceWithEncode obj) {
		char[] output = obj.getInput();
		int j = output.length - 1;
		int i = output.length - 1;
		while (output[i] == ' ') {
			i--;
		}

		while (i >= 0) {
			if (output[i] == ' ') {
				output[j--] = '0';
				output[j--] = '2';
				output[j--] = '%';
				i--;
			} else {
				output[j--] = output[i--];
			}
		}
		obj.setInput(output);
	}
}
