
public class ParityBitCheck {

	public static boolean evenParity(Integer value){
        int i =0;
        boolean result = false;

        do{
           if ((value&1) == 1){
                i++;
           }
            value = value>>1;
        }while(value == 0);

        if(i % 2 == 0){
            result = true;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(evenParity(1010));
	}
}
