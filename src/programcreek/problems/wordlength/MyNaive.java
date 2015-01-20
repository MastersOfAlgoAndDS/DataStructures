package programcreek.problems.wordlength;

import java.util.HashSet;

public class MyNaive {
	int len;
	boolean endFoundFlag;
	
	int compareWords(String w1, String w2){
		char[] temp1 = w1.toCharArray();
		char[] temp2 = w2.toCharArray();
		int difflen=0;
		for(int i=0; i<w1.length(); i++){
			if(temp1[i]!=temp2[i])
				difflen++;
		}
		return difflen;
	}
	
	int ladderLength(String start, String end, HashSet<String> dict){
		String temp=start;
		int difflen=0;
		if(compareWords(temp, end)==1){
			endFoundFlag=true;
			len++;
		}
		HashSet<String> tempDict = new HashSet<String>(dict);
			
		for(String dictiter : dict){
			difflen=compareWords(start, dictiter);
			if(difflen==1){
				System.out.println("Dictionary HIT!!!");
				System.out.println("Now the considered word is: " + dictiter);
				tempDict.remove(dictiter);
				
				//difflen=ladderLength(dictiter, end, tempDict);
				len++;
				for(String iter : tempDict){
					len++;
				}
				if(compareWords(dictiter, end)==1){
					endFoundFlag=true;
					len++;
					break;
				}
			}

		}
		return difflen;
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
		
		MyNaive sol = new MyNaive();
		sol.endFoundFlag=false;
		sol.len=1;
		System.out.println("Ladder length is " + sol.ladderLength(start, end, dict));
	}

}
