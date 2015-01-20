package com.spoj;

import java.util.Scanner;

public class Prime1 {
	public boolean isPrime(int n) {
		//check if n=1 to return it as a prime number
		if (n==1) return false;
		//check if n=2 to return it as a prime number
		if (n==2) return true;
	    //check if n is a multiple of 2, so as to remove all the even numbers from the input set.
		if (n%2==0) return false;
	    //if not, then just check the odds for divisibility
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	private static void primeChecker(int num1,int num2){
		Prime1 p = new Prime1();
		for(int i= num1; i<=num2; i++){
			if(true==p.isPrime(i))
				System.out.println(i);
		}
		System.out.println("");
	}

	public static void main(String args[]){
		int t;
		Prime1 p = new Prime1();
		Scanner s = new Scanner(System.in);
		t = s.nextInt();
		int [][]input = new int[t][2];
		for(int i=0; i<t; i++){
			for(int j= 0; j<2; j++){
				input[i][j] =s.nextInt(); 
			}			
		}
		for(int i =0; i<t; i++){
			p.primeChecker(input[i][0], input[i][1]);
		}
	}
}

