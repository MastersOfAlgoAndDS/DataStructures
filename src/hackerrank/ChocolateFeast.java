/**
 * https://www.hackerrank.com/challenges/chocolate-feast
 * */
package hackerrank;

import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        
    	int chocCnt = N/C;
    	int wrapChocCnt = chocCnt/M;
    	int wrapCnt = chocCnt%M;
    	while(wrapChocCnt>=M){
    		chocCnt += wrapChocCnt;
    		int temp = wrapChocCnt;
    		wrapChocCnt = (temp + wrapCnt) / M;
    		if(temp>M){
    			wrapCnt = temp % M;
    		}
    		else{
    			wrapCnt = 0;
    		}
    	}
    	wrapChocCnt += (wrapChocCnt + wrapCnt) / M;
    	chocCnt += wrapChocCnt;
    	return chocCnt;
         //Write code to solve each of the test over here
    	//test 6 2 2
    	// 3 1 1
    	// 4 1 0
    	// 
    	
    }

}
