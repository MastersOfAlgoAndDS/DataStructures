package programcreek.problems.wordlength;

import java.util.HashSet;

import com.sun.org.apache.bcel.internal.generic.LADD;

public class Naive {
	public int ladderLength(String start, String end, HashSet<String> dict){
		int len=0;

		
		for(int i=0; i<start.length(); i++){
			char[] startArr = start.toCharArray();
			char c;
			for(c='a'; c<'z'; c++){
				if(c==startArr[i])
					continue;
				startArr[i]=c;
				System.out.println("Now startArr is " + new String(startArr));
				String temp = new String(startArr);
				if(dict.contains(temp)){
					System.out.println("Dictionary HIT!!!");
					start = temp;
					dict.remove(temp);
					System.out.println("Now start is " + start);
					len++;
					if(temp.equals(end))
						return len;
				}
			}

		}
		System.out.println("Finally start is " + start);
		return len;
	}
	
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		Naive sol = new Naive();
		System.out.println("Ladder length is " + sol.ladderLength(start, end, dict));
	}
}
