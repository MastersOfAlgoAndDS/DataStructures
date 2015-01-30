package hackerrank;

import java.util.Scanner;


class FlippingBits{

	public static long flippingBits(long n){
		int[] binary = new int[32];
		for(int i=0; i<binary.length;i++ )
			binary[i]=0;
		int indx = 31;
		long r;		
		while(n>=1){

			r = n%2;
			n = n/2;
			binary[indx--] = (int)r;
		
		}
		
/*		for(int i=0; i<binary.length;i++){
			System.out.print(binary[i]);
		}
		System.out.println();
*/
		for(int i=0; i<binary.length;i++){
			if(binary[i]==0)
				binary[i]=1;
			else binary[i] = 0;
		}

/*		for(int i=0; i<binary.length;i++){
			System.out.print(binary[i]);
		}
		System.out.println();
*/
		long res=0;
		for(int i = 31; i>=0; i--){
/*			System.out.println(res);
*/			res = (res + ((long)Math.pow(2, 31-i) * binary[i]));
			
		}
	return res;
	}
	


	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t;
        long sum;
        long a;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextLong();
            sum = flippingBits(a);
            System.out.println(sum);
            //System.out.println(sum);
        }
		
	}

}