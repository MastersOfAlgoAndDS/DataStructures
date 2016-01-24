package google;

import java.util.ArrayList;

public class LargestImageFilePath {
	public int getIndentCnt(String str) {
		int spaceCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				spaceCnt++;
			else
				break;
		}
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

	public static void main(String[] args) {
		String X = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		LargestImageFilePath s = new LargestImageFilePath();
		System.out.println(s.solution(X));

	}

}
