// ShellSort.java

// InsertionSort.java

import java.util.*;

public class ShellSort
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		
		// Knuth's 3x + 1 sequence for doing our
		// shell sort
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j-=h) {
					if (less(a[j], a[j-h]))
						swap(a, j-h, j);
				}
			}
			h = h/3;
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
		ShellSort Shell = new ShellSort();
		Shell.sort(a);
		System.out.print("\n\nArray after sorting: ");
		for (int f = 0; f < N; f++)
			System.out.format(" %d ", a[f]);		
	}
}