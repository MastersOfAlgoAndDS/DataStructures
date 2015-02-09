package hackerrank;

import java.util.*;

class UtopianTree{

        public static int utopianTree(int n){
                int cnt=0;
                int ht = 1;
                while(cnt<=n){
                        if(cnt==0)
                                ht=1;
                        else if(cnt%2==0)
                                ht++;
                        else if(cnt%2==1)
                                ht*=2;
                        cnt++;
                }
                return ht;
        }

        @SuppressWarnings("resource")
		public static void main(String[] args){
                Scanner in = new Scanner(System.in);
                int t= in.nextInt();
                int a;
                int result;
                for(int i = 0; i<t; i++){
                        a = in.nextInt();
                        result = utopianTree(a);
                        System.out.println(result);
                }
        }

}
