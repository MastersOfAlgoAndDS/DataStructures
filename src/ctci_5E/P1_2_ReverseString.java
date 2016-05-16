package ctci_5E;

/**
 * @Problem_1_2 Implement a function void reverse(char* str) in C or C++ which
 *              reverses a nullterminated string.
 * 
 *              Since objects are pass by value in JAVA, we follow an object
 *              oriented approach. We cannot do this using pointers or by using
 *              String primitive datatype in java since primitive data types are
 *              pass by value in java so after reversing the string we cannot
 *              assign the input string again.
 * 
 *              !!! Another approach can be to put two pointers at the start and
 *              end of the string and keep swapping until smaller pointer is
 *              less than the larger pointer.
 * @author Milind
 *
 */
public class P1_2_ReverseString {

	String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * 
	 * Runtime: O(n)
	 * 
	 * @param obj
	 */
	public void reverse(P1_2_ReverseString obj) {
		String output = "";
		for (int i = obj.getInput().length() - 1; i > -1; i--) {
			output += obj.getInput().charAt(i);
		}
		obj.setInput(output);
	}

	/**
	 * 
	 * O(n/2) = O(n)
	 * 
	 * @param obj
	 */
	public void reverseInPlace(P1_2_ReverseString obj) {
		char[] input = obj.getInput().toCharArray();
		int i = 0, j = input.length - 1;
		while (i < j) {
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		obj.setInput(String.valueOf(input));
	}

	public static void main(String[] args) {
		String str = "Hello";
		P1_2_ReverseString s = new P1_2_ReverseString();
		s.setInput(str);
		System.out.println(s.getInput());
		s.reverse(s);
		System.out.println(s.getInput());
		String newStr = "ReverseIt";
		P1_2_ReverseString s1 = new P1_2_ReverseString();
		s1.setInput(newStr);
		System.out.println(s1.getInput());
		s.reverseInPlace(s1);
		System.out.println(s1.getInput());

	}
}
