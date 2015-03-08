package geeksforgeeks;

import java.util.Stack;

public class TheStockSpan {
	public static void main(String[] args){
		//int[] inputArray = {100, 80,60,70,60,75,85};
		int[] inputArray = {10,4,5,90,120,80};
		Stack<Integer> st = new Stack<Integer>();
		int[] outputArray = new int[inputArray.length];
		
		st.push(0);
		outputArray[0] = 1;
		int cnt=1;
		int stackTop =inputArray[st.peek()];
		for(int i=1; i<inputArray.length; i++){
			if(!st.isEmpty()){
				stackTop = inputArray[st.peek()];
			}
			if(stackTop<inputArray[i]){
				cnt=1;
				while(!st.isEmpty() && stackTop<inputArray[i]){
					cnt+=outputArray[st.pop()];
					if(!st.isEmpty()){
						stackTop = inputArray[st.peek()];
					}
				}
				outputArray[i]=cnt;
				st.push(i);
			}
			else{
				cnt=1;
				outputArray[i]=cnt;
				st.push(i);
			}
				
		}
		System.out.println();
		for(int i=0; i<outputArray.length; i++){
			System.out.print(outputArray[i] + " ");
		}
	}
}
