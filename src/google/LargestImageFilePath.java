package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @Problem: You're given a listing of directories and files in a file system.
 *           Each directory and file has name, which is a non-empty string
 *           consisting of alphanumerical characters. Additionally, the name of
 *           each file contains a single dot character; part of the name string
 *           with the dot is called the extension. Directory names do not
 *           contain any dots. All the names are case-sensitive. Each entry is
 *           listed on a separate line. Every directory is followed by a listing
 *           of its contents indented by one space characters. The contents of
 *           the root directory are not indented.
 * 
 *           Here is a sample listing:
 * 
 *           dir1\n dir11\n dir12\n picture.jpeg\n dir121\n file1.txt\n dir2\n
 *           file2.gif
 * 
 *           The absolute path of a file is a string containing the names of
 *           directories which have to be traversed to reach the file, separated
 *           by slash characters. Example: the absolute path to file1.txt is
 *           "/dir1/dir12/file1.txt". There is no drive letter like "C:" and
 *           each absolute path starts with a slash. We are interested in only
 *           image files; i.e. files with extensions .jpeg, .gif and .png. We're
 *           looking for the longest absolute path leading to some image file.
 *           For example: in the file system described above there are two image
 *           files and the longest path to an image file is
 *           "/dir1/dir12/picture.jpeg" which is 24 characters long.
 * 
 * 
 * @Solution: The logic here is to first split the entire line in next line
 *            characters. To get a line by line structure like we get in ls.
 * 
 *            Then we have to keep storing every directory into an array of
 *            stacks where the array index denotes the directory level of
 *            indentation and the value is a stack containing all the
 *            directories at that level.
 * 
 *            Then for finding absolute path of a file we just peek the stack
 *            and get the directory in which the file is present. And we
 *            construct the absolute path of the file by concatination of all
 *            the directory names with / from 0, down till the file level.
 * 
 * @Time_Complexity: O(n)
 * @Space_Complexity: O(2n)
 * 
 * @author Milind
 *
 */
public class LargestImageFilePath {
	public int getIndentCnt(String str) {
		int spaceCnt = str.length() - str.trim().length();
		return spaceCnt;
	}

	public boolean isImageFile(String str) {
		if (str.endsWith("jpeg") || str.endsWith("png") || str.endsWith("gif"))
			return true;
		return false;
	}

	public boolean isDirectory(String str) {
		if (!isImageFile(str) && !str.contains("."))
			return true;
		return false;
	}

	public int solution(String S) {
		String[] temp = S.split("\n");
		HashMap<Integer, Stack<String>> dirMap = new HashMap<Integer, Stack<String>>();
		int maxImageFilePath = 0;
		for (String line : temp) {
			int spaceCnt = getIndentCnt(line);
			if (isImageFile(line)) {
				// construct absolute path.
				int i = 0;
				String absPath = "";
				while (i < spaceCnt) {
					absPath += ("/" + dirMap.get(i).peek());
					i++;
				}
				absPath += ("/" + line.trim());
				if (absPath.length() > maxImageFilePath)
					maxImageFilePath = absPath.length();
			} else {
				// make entry in the hashmap of stacks.
				if (dirMap.containsKey(spaceCnt)) {
					dirMap.get(spaceCnt).push(line.trim());
				} else {
					dirMap.put(spaceCnt, new Stack<String>());
					dirMap.get(spaceCnt).push(line.trim());
				}
			}
		}
		return maxImageFilePath;
	}

	public static void main(String[] args) {
		String X = "dir1\n dir11\n dir12\n  picture.txt\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		LargestImageFilePath s = new LargestImageFilePath();
		System.out.println(s.solution(X));

	}

	public int solutionincomplete(String S) {
		int imageFileCnt = 0;
		String[] temp = S.split("\n");
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<String> absPaths = new ArrayList<String>();
		for (int i = 0; i < temp.length; i++) {
			if (isImageFile(temp[i])) {
				imageFileCnt++;
				indices.add(i);
			}
		}
		if (imageFileCnt == 0)
			return 0;

		for (int i = imageFileCnt - 1; i >= 0; i--) {
			String absPath = "";
			int j = indices.get(i);
			int currDepth = 256;
			while (j >= 0) {
				// get the parent directories for current image file
				if (getIndentCnt(temp[j]) < currDepth) {
					absPath = temp[j] + absPath;
					currDepth--;
					j--;
				}
			}
			absPath = "\\" + absPath;
			// System.out.println(absPath);
			absPaths.add(absPath.replace(" ", ""));
		}

		int maxPathLength = -1;
		for (String absPathStr : absPaths) {
			if (absPathStr.length() > maxPathLength)
				maxPathLength = absPathStr.length();
			System.out.println(absPathStr);
		}
		// System.out.println(imageFileCnt);
		return maxPathLength;
	}

}
