package stackoverflow;

public class CharacterStringCompare {

	public static void main(String[] args) {
		String str1 = "binary";
		String str2 = "bind";
		CharacterStringCompare s = new CharacterStringCompare();
		System.out
				.println(s.lessThan(str1.toCharArray(), str2.toCharArray(), 7));

	}

	public boolean lessThan(char[] s, char[] t, int n) {
		int i = 0, j = 0, q = 0;
		while (i < s.length && i < t.length && (i < n)) {
			if (s[i] > t[i])
				return false;
			i++;
		}
		if (s.length > t.length && i > t.length - 1)
			return false;
		else if (n < i)
			return true;
		return true;
	}

}
