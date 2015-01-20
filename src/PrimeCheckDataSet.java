import java.text.SimpleDateFormat;
import java.util.Date;


public class PrimeCheckDataSet {

	public boolean isPrimeBetter(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public boolean isPrimeBasic(int n) {
	    for(int i=2;i<=n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public static void printDate(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
	    String strDate = sdfDate.format(now);
	    System.out.print(strDate);
	}
	
	public static void main(String args []){
		int m = 50;
		int n = 200000;
		PrimeCheckDataSet p = new PrimeCheckDataSet();
		long startDate,finishDate;
		startDate=System.currentTimeMillis();
		System.out.println("");
		for(int i = m; i<=n ; i++){
			if(true==p.isPrimeBetter(i))
				System.out.println(" " + i + ",");
		}
		System.out.print("\nRunning Time With isPrimeBetter: ");
		finishDate=System.currentTimeMillis();
		System.out.println(finishDate-startDate);
		
		startDate=System.currentTimeMillis();
		System.out.println("");
		for(int i = m; i<=n ; i++){
			if(true==p.isPrimeBasic(i))
				System.out.println(" " + i + ",");
		}
		System.out.print("\nRunning Time With isPrimeBasic: ");
		finishDate=System.currentTimeMillis();
		System.out.println(finishDate-startDate);
		
	}
}
