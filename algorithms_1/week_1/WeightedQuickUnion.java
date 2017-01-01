// Weighted QuickUnion

// we always link the root of a smaller tree to
// the root of a larger tree in order not make 
// the height of the trees grow too fast.

import java.util.*;

public class WeightedQuickUnion
{
	// our main data-structure
	// an array to represent the objects and
	// their positions
	private int[] id;
	
	// additional data-structure
	// an array to count the number of
	// objects in the tree rooted at any position i
	private int[] sz;
	
	// constructor
	public WeightedQuickUnion(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// root of a node
	public int root(int n) {
		while (n != id[n]) {
			n = id[n];
		}
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
		
		// both p and q already belong to the
		// same connected component
		if (proot == qroot) 
			return;
		
		if (sz[proot] < sz[qroot]) {
			
		}
	}
	
	// Client code
	public static void main(String[] args)
	{
		// read from standard input
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		WeightedQuickUnion WQU = new WeightedQuickUnion(N);
		while (scan.hasNextLine()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!WQU.connected(p, q)) {
				WQU.union(p, q);
				System.out.format("(%d %d)%n", p, q);
			}
		}
	}

}