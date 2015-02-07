import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalinProb {
	/*
	 * Complete the function below.
	 */

	public static boolean palindromeCheck(String str) {
		char[] mychar = str.toCharArray();
		int i = 0;
		int j = mychar.length - 1;
		// System.out.println("given string is "+ str);
			while (i < j) {
				if (mychar[i] == mychar[j]) {
					i++;
					j--;
				} else
					return false;
			}
		return true;
	}

	static int palindrome(String str) {
		// ArrayList<String> list = new ArrayList<String>();
		Set<String> myset = new HashSet<String>();

		int len = str.length();
		char[] ques = str.toCharArray();
		StringBuilder mystr = new StringBuilder(str);
		int numofpalin = 0;

		// Take all the unique characters and add it to the dictionary
		for (int i = 0; i < len; i++) {
			if (!myset.contains(mystr.substring(i, i + 1)))
				myset.add(mystr.substring(i, i + 1));
		}

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				// System.out.print(i + " " + j);
				// System.out.println(mystr.substring(i, j));
				StringBuilder temp = new StringBuilder(mystr.substring(i, j));
				if (temp.length() != 1 && palindromeCheck(temp.toString())) {
					System.out.println("palindrome is " + temp);
					// palindrome found. put it in arraylist
					if (!myset.contains(temp))
						myset.add(temp.toString());
				}
			}
		}

		// code for printing the contents of the HashSet
		/*
		 * for (int i = 0; i < myset.size(); i++) { System.out.println(myset); }
		 */
		return myset.size();

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("C:\\");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}

		res = palindrome(_str);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();

		// bw.close();
	}
}
