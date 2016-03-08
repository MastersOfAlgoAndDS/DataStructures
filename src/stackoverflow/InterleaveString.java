package stackoverflow;

public class InterleaveString {

	public static void main(String[] args) {
		// InterleaveString s = new InterleaveString();
		System.out.println(interleaveWithRuns("abc", "xyz"));
	}

	public static java.lang.String interleaveWithRuns(java.lang.String s,
			java.lang.String t) {
		String str = "";
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			if ((i < s.length() - 1) && (s.charAt(i) == s.charAt(i + 1))) {
				str += String.valueOf(s.charAt(i))
						+ String.valueOf(s.charAt(i + 1));
				str += String.valueOf(t.charAt(j));
				i++;
			} else if ((j < t.length() - 1) && (t.charAt(j) == t.charAt(j + 1))) {
				str += String.valueOf(s.charAt(i));
				str += String.valueOf(t.charAt(j))
						+ String.valueOf(t.charAt(j + 1));
				j++;
			} else {
				str += s.charAt(i) + "" + t.charAt(j);
			}
			i++;
			j++;
		}
		while (i < s.length()) {
			str += s.charAt(i);
			i++;
		}
		while (j < t.length()) {
			str += t.charAt(j);
			j++;
		}
		return str;
	}

}
