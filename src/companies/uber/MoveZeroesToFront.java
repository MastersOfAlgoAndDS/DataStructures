package companies.uber;

public class MoveZeroesToFront {

	public static void main(String[] args) {
		int[] array = {1,0,-1,0,2,0,1,0,0,0,0,1,0,0,0,0,0,0,0};
		//int[] array = {0,0,0,0,0,0,0};
		
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
		int[] arr = MoveZeroesToFront_N(array);
		for(int i : arr)
			System.out.print(i + " ");
	}

	private static int[] MoveZeroesToFront_NSquare(int[] array) {
		
		int count = 0;
		int k=0;
		for(int i=array.length-1; i>0; i--){
			System.out.println("iteration: " + i+1);
			if(array[i]==0){
				count++;
				for (int j=i; j>0; j--){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1]=temp;
				}
				i++;
			}
			else
				k++;
		if(k+count == array.length)
			break;
		}
		return array;
		
	}
	
	public static int[] MoveZeroesToFront_N(int[] arr){
		
		int len = arr.length -1 ;
		
		
		for(int i = arr.length - 1 ; i >= 0; i-- ){
			System.out.println("iteration: " + i);
			if(arr[i]!=0){
				arr[len--] = arr[i];
			}
		}
		while(len>=0){
			arr[len--] = 0;
		}
		
		return arr;
		
	}
	
}
