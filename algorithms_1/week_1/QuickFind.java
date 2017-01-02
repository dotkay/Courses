// Algorithms - week 1
// Quick Find Algorithm

import java.util.*;

public class QuickFind 
{
	private int[] id;
	
	// constructor
	public QuickFind(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// find/connected query
	public boolean connected(int p, int q)
	{
		return (id[p] == id[q]);
	}
	
	// union operation
	public void union(int p, int q) 
	{
		// since the index of the array is the same as the content
		// through construction (constructor), id[x] will give the 
		// index of the element x
		int pid = id[p]; // get the id of p in the array
		int qid = id[q]; // get the id of q in the array
		
		// traverse the array and replace the id of p with id of q
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
	}

	public void print_result(int N) {
		for (int i = 0; i < N; i++) {
			System.out.format("%d ", id[i]);
		}
	}

	// Client code
	public static void main(String[] args) 
	{
		// read from standard input
		Scanner scan = new Scanner(System.in);
		
		// the first line of the input text file 
		// indicates the number of objects.
		// Scan it and used it in our constructor
		int N = scan.nextInt();
		
		QuickFind QF = new QuickFind(N);		
		while (scan.hasNextLine()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!QF.connected(p, q)) {
				QF.union(p, q);
				System.out.format("(%d %d)%n", p, q);
			}
		}		
		QF.print_result(N);
		scan.close();
	}
}

