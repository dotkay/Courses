// Algorithms - week 1
// Quick Find Algorithm

import java.util.*;

public class QuickUnion
{
	private int[] id;
	
	// constructor
	public QuickUnion(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// root of a node 
	private int root(int n)
	{
		while(n != id[n])
			n = id[n];
		return n;
	}
	
	// find/connected query
	public boolean connected(int p, int q) 
	{
		return (root(p) == root(q));
	}
	
	// union operation
	public void union(int p, int q)
	{
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
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
		int N = scan.nextInt();
		QuickUnion QU = new QuickUnion(N);
		while (scan.hasNextLine()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!QU.connected(p, q)) {
				QU.union(p, q);
				System.out.format("(%d %d)%n", p, q);
			}
		}
		QU.print_result(N);
		scan.close();
	}

}