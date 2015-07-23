package uber;

public class MoveZeroesToFront {

	public static void main(String[] args) {
		int[] array = {1,0,-1,0,2,0,1,0,0,0,0,1,0,0,0,0,0,0,0};
		//int[] array = {0,0,0,0,0,0,0};
		
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
		int[] arr = MoveZeroesToFront(array);
		for(int i : arr)
			System.out.print(i + " ");
	}

	private static int[] MoveZeroesToFront(int[] array) {
		
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
	
	
	
}
