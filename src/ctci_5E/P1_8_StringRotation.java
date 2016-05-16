package ctci_5E;

/**
 * @Problem_1_8 Assume you have a method isSubstring which checks if one word is
 *              a substring of another. Given two strings, si and s2, write code
 *              to check if s2 is a rotation of si using only one call to
 *              isSubstring e.g.,"waterbottle"is a rotation of "erbottlewat".
 * 
 * @solution String the string s1 twice like "waterbottlewaterbottle" and search
 *           "erbottlewat" as a substring in s1. Also check if the length of
 *           both s1 and s2 are same. Because the logic will also give true for
 *           input "erbottlewa" where last t is not given. So the length does
 *           not match.
 * 
 * @Runtime: O(1) or say O(n) where n is the length of the string because the
 *           isSubstring will also take some time and joining two strings to
 *           form a string will also take some time.
 * 
 *           Space complexity will also be O(n) because copying one string twice
 *           and forming a new string will occupy double space.
 * 
 * @author Milind
 *
 */
public class P1_8_StringRotation {

	public static void main(String[] args) {
		P1_8_StringRotation s = new P1_8_StringRotation();
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(s.isRotation(s1, s2));

	}

	/**
	 * String the string s1 twice like "waterbottlewaterbottle" and search
	 * "erbottlewat" as a substring in s1. Also check if the length of both s1
	 * and s2 are same. Because the logic will also give true for input
	 * "erbottlewa" where last t is not given. So the length does not match.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private boolean isRotation(String s1, String s2) {
		return (s1.length() == s2.length()) && isSubstring(s1 + s1, s2);
	}

	private boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}

}
