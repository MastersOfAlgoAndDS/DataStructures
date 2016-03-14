package stackoverflow;

import java.util.Scanner;

public class QuickSort {
	public void sort(int a[], int low, int high) {

		if (low < high) {
			int q = partition(a, low, high);
			sort(a, low, q - 1);
			sort(a, q + 1, high);
		}
	}

	public int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (a[j] <= pivot) {
				i++;
				exchange(a[i], a[j]);
			}
		}
		exchange(a[i + 1], a[high]);
		return i + 1;
	}

	public void exchange(int v1, int v2) {
		int var1 = v1;
		int var2 = v2;
		var1 = var1 + var2;
		var2 = var1 - var2;
		var1 = var1 - var2;
		// System.out.println(var1);
		// System.out.println(var2);
	}

	public void printArr(int a[]) {
		int n = a.length;
		System.out.println("SORTED ARRAY");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print("\t");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuickSort obj = new QuickSort();
		// TODO Auto-generated method stub

		System.out.println("Enter the no of elements in array");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of array");
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		obj.sort(arr, 1, arr.length);
		obj.printArr(arr);

		sc.close();
	}
}