/**
 * Design an algorithm that takes a string s and a string r, assumed to be 
 * a well-formed ESRE, and checks if r matches s.
 * 
 * The key to solving this problem is using recursion eectively.
 * If r starts with ^, then the remainder of r, i.e., r1, must strictly match a prefix of s.
 * If r ends with a $, some sux of s must be strictly matched by r without the trailing
 * $. Otherwise, r must strictly match some substring of s.
 * Call the function that checks whether r strictly matches a prefix of string s
 * is_match. This function has to check several cases:
 * (1.) Length-0 ESREs which match everything.
 * (2.) An ESRE starting with ^ or ending with $.
 * (3.) An ESRE starting with an alphanumeric character or dot.
 * (4.) An ESRE starting with a  match, e.g., awXY or .Wa.
 * Case (1.) is a base case. Case (2.) involves a check possibly followed by a recursive
 * call to is_match_here. Case (3.) requires a single call to is_match_here. Case (4.) is
 * handled by a walk down the string s, checking that the prefix of s thus far matches
 * the alphanumeric character or dot until some sux of s is matched by the remainder
 * of the ESRE, i.e., r2.
 * 
 *  
 * */

package EPI;

public class Problem_6_5_RegularExpression {

	public boolean isMatch(String r, String s) {
		if (r.startsWith("^")) {
			return isMatchStrict(r.substring(1), s);
		}

		for (int i = 0; i <= s.length(); ++i) {
			if (isMatchStrict(r, s.substring(i))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * Function to check strict match
	 * 
	 * @param r
	 * @param s
	 * @return
	 */
	public boolean isMatchStrict(String r, String s) {
		if (r.isEmpty()) {
			return true;
		}

		if (r == "$") {
			return s.isEmpty();
		}

		if (r.length() > 2 && r.charAt(1) == '*') {
			for (int i = 0; i < s.length()
					&& (r.startsWith(".") || r.charAt(0) == s.charAt(0)); ++i) {
				if (isMatchStrict(r.substring(2), s.substring(i + 1))) {
					return true;
				}
			}
			return isMatchStrict(r.substring(2), s);
		}

		return !s.isEmpty()
				&& (r.startsWith(".") || r.charAt(0) == s.charAt(0))
				&& isMatchStrict(r.substring(1), s.substring(1));
	}

	public static void main(String[] args) {

		String r = "aa*W9aW";
		String s = "aaaajaaW9aW";
		System.out
				.println("This program checks whether string S matches with string r");
		Problem_6_5_RegularExpression p = new Problem_6_5_RegularExpression();
		System.out.println("r is: " + r);
		System.out.println("s is: " + s);
		System.out.println(p.isMatch(r, s));
		// TODO There is still a small problem in this program. as seen in the
		// output.
	}

}
