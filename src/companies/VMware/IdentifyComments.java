/*
 * Building a Smart IDE: Identifying comments
 * https://www.hackerrank.com/contests/regex-practice-1/challenges/ide-identifying-comments
 */
package companies.VMware;

import java.util.Scanner;

public class IdentifyComments {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String currLine = in.nextLine();

			if (currLine.contains("//")) { // single line comments
				System.out.println(currLine.substring(currLine.indexOf("//")));
			} else if (currLine.contains("/*")) { // multi-line comments
													// handling
				int idxStart = currLine.indexOf("/*");
				if (currLine.contains("*/")) {
					int idxEnd = currLine.indexOf("*/") + 2;
					System.out.println(currLine.substring(idxStart, idxEnd));
				} else {
					while (in.hasNextLine()) {
						while (!currLine.contains("*/")) {
							System.out.println(currLine);
							currLine = in.nextLine();
						}
						System.out.println(currLine.substring(0,
								currLine.indexOf("*/") + 2));
						break;
					}
				}
			}
		}
		in.close();
	}
}
