/**
 * To detect domain names in the text. 
 * 
 * Sample Input: input001.txt
 * Sample Output: output001.txt
 * 
 *  
 * 
 * */

package VMware.domaindetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DOMAIN {
	static Set<String> uniqueDomains = new HashSet<String>();

	public static void main(String[] args) {
		// Pattern p =
		// Pattern.compile("https?:\/\/((?:[\-a-zA-Z0-9]+\.)*[\-a-zA-Z0-9]+\.[a-zA-Z0-9]+(?:[a-zA-Z0-9]+)?)");
		// Pattern p = Pattern
		// .compile("https?:\\/\\/((?:[\\-a-zA-Z0-9]+\\.)*[\\-a-zA-Z0-9]+\\.[a-zA-Z0-9]+(?:[a-zA-Z0-9]+)?)");
		//
		// Matcher m = p.matcher("http://www.mil.com/");
		// // System.out.println(m.find());
		// // System.out.println(m.matches());
		// while (m.find()) {
		// System.out.println(m.group().replace("http://www.", ""));
		// }
		//
		// p = Pattern.compile("^\\d\\d\\d$");
		// m = p.matcher("123");
		// System.out.println(m.find());
		// System.out.println(m.matches());

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("window.location.href = \"http://track.rediff.com/click?url=___https://mail.rediff.com/cgi-bin/login.cgi___&cmp=rediffmail&lnk=rediffmail&nsrv1=inhome\";");
		printUniqueDomains(arr);
		Scanner in = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		while (in.hasNext()) {
			String currLine = in.next();
			if (currLine.equals("DONE!"))
				break;
			input.add(currLine);
		}
		printUniqueDomains(input);
	}

	static void printUniqueDomains(ArrayList<String> arr) {
		Pattern p = Pattern
				.compile("https?:\\/\\/((?:[\\-a-zA-Z0-9]+\\.)*[\\-a-zA-Z0-9]+\\.[a-zA-Z0-9]+(?:[a-zA-Z0-9]+)?)");

		for (String currString : arr) {
			Matcher m = p.matcher(currString);
			while (m.find()) {
				String currDomain = m.group().replace("http://www.", "")
						.replace("https://www.", "").replace("http://", "")
						.replace("https://", "");
				if (!uniqueDomains.contains(currDomain)) {
					uniqueDomains.add(currDomain);
					System.out.print(currDomain);
					System.out.print(";");
				}
			}

		}

	}

}
