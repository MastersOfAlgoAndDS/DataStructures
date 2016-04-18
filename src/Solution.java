import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {

	public static boolean isAnagram(String A, String B) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if (A.length() != B.length())
			return false;
		for (char character : A.toCharArray()) {
			if (!map.containsKey(character))
				map.put(Character.toLowerCase(character), 1);
			else
				map.put(character, map.get(character) + 1);
		}
		for (char character : B.toCharArray()) {
			if (map.containsKey(Character.toLowerCase(character))) {
				map.put(Character.toLowerCase(character),
						map.get(Character.toLowerCase(character)) - 1);
			} else
				return false;
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0)
				return false;
		}
		return true;
	}

	public static boolean isAnagramList(List<String> input) {
		if (input == null)
			return false;
		else {
			int length = input.get(0).length();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (char character : input.get(0).toCharArray()) {
				if (!map.containsKey(character))
					map.put(Character.toLowerCase(character), 1);
				else
					map.put(character, map.get(character) + 1);
			}

			int i = 1;
			while (i < input.size()) {
				HashMap<Character, Integer> bufferMap = (HashMap<Character, Integer>) map
						.clone();
				if (length != input.get(i).length())
					return false;
				else {

					for (char character : input.get(i).toCharArray()) {
						if (bufferMap.containsKey(Character
								.toLowerCase(character))) {
							bufferMap
									.put(Character.toLowerCase(character),
											map.get(Character
													.toLowerCase(character)) - 1);
						} else
							return false;
					}

					for (Entry<Character, Integer> entry : bufferMap.entrySet()) {
						if (entry.getValue() != 0)
							return false;
					}

				}
				i++;
			}
		}

		return true;
	}

	public static void main(String[] args) {
	}

	public int solution(int[] a) {
		int n = a.length;
		if (n < 1)
			return -1;

		int max = 0;
		int ans = 0;

		for (int i = n - 1; i >= 0; --i) {
			if (a[i] > max)
				max = a[i];

			int temp = max - a[i];
			if (temp > ans)
				ans = temp;
		}

		return ans;
	}

	static long kSub(int k, int[] nums) {
		int[] cntMod = new int[nums.length];
		cntMod[0] = 1;
		int prefSum = 0;
		for (int elem : nums) {
			prefSum += elem;
			prefSum %= k;
			cntMod[prefSum]++;
		}
		long res = 0;
		for (int mod = 0; mod < k; mod++)
			res += (long) cntMod[mod] * (cntMod[mod] - 1) / 2;
		return res;
	}

}
