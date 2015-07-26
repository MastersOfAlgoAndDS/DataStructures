package EPI;

public class Utilities {

	public static String decToBin(int n){
		String result = "";
		if(n==0) return "0";
		while(n>0){
			result = n%2 + result;
			n = n/2;
		}
		return result;
	}

	public static int binToDec(String bin){
		int result = 0;
		for(int i=bin.length()-1; i>=0; i-- ){
			result += Math.pow(2, bin.length()-1-i) * (bin.charAt(i)-48);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int num = 64;
		System.out.println(decToBin(124>>3));
		System.out.println(binToDec("0110010"));

	}

}
