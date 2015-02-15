package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class AngryChildren {
   static BufferedReader in = new BufferedReader(new InputStreamReader(
         System.in));
   static StringBuilder out = new StringBuilder();
   
   public static int angryChildren(int[] nums, int k){
	   int len = nums.length - k;
	   Arrays.sort(nums);
	   
	   int[] arr = new int[len];
	   int minK = Integer.MAX_VALUE;
	   for(int i =0; i<(len); i++){
		   arr[i] = nums[i+k-1] - nums[i];
	   }
	   //minK = arr[0];
	   for (int i = 0; i<(len); i++){
		   if(arr[i] < minK){
			   minK = arr[i];
		   }
	   }
	   
	   return minK;
	   
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      int numPackets = Integer.parseInt(in.readLine());
      int numKids = Integer.parseInt(in.readLine());
      int[] packets = new int[numPackets];
      
      for(int i = 0; i < numPackets; i ++)
      {
         packets[i] = Integer.parseInt(in.readLine());
      }
      
      int unfairness = Integer.MAX_VALUE;
      
        // Write your code here, to process numPackets N, numKids K, and the packets of candies
      // Compute the ideal value for unfairness over here
      int result = angryChildren(packets, numKids);
      
      System.out.println(result);
   }
}
