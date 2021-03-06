// InsertionSort.java

import java.util.*;

public class InsertionSort
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1]))
					swap(a, j-1, j);
			}
		}
	}

	// helper functions
	// swap - to swap two elements of an array
	private static void swap(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// less - compare two elements of an array (Comprable type elements)
	// return 'true' if v < w
	private static boolean less(Comparable v, Comparable w) 
	{
		return v.compareTo(w) < 0;
	}

	// Client code
	public static void main(String[] args)
	{
		// scanner to get standard input
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Comparable[] a = new Comparable[N];
		int i = 0;
		while (scan.hasNextLine()) { 
			a[i++] = scan.nextInt(); 
		}
		System.out.print("Array before sorting: ");
		for (int b = 0; b < N; b++)
			System.out.format(" %d ", a[b]);
		System.out.print("\n\nArray after sorting: ");
		InsertionSort Insertion = new InsertionSort();
		Insertion.sort(a);
		for (int f = 0; f < N; f++)
			System.out.format(" %d ", a[f]);		
	}
}