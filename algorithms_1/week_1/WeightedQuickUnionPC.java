// Weighted QuickUnion with Path Compression

// we always link the root of a smaller tree to
// the root of a larger tree in order not make 
// the height of the trees grow too fast.

import java.util.*;

public class WeightedQuickUnionPC
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
	public WeightedQuickUnionPC(int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			// initializing size of each node to be 1 
			sz[i] = 1;
		}
	}
	
	// root of a node
	public int root(int n) {
		while (n != id[n]) {
			// make each intermediate node encountered during
			// our search for the root, point to the root.
			// i.e. the root of each intermediate node is the 
			// root we are searching for
			id[n] = id[id[n]];
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
			// root of q becomes root of p
			id[proot] = qroot;
			sz[qroot] += sz[proot];
		}
		else {
			// root of p becomes root of q
			id[qroot] = proot;
			sz[proot] += sz[qroot];
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
		int N = scan.nextInt();
		WeightedQuickUnionPC WQU = new WeightedQuickUnionPC(N);
		while (scan.hasNextLine()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!WQU.connected(p, q)) {
				WQU.union(p, q);
				System.out.format("(%d %d)%n", p, q);
			}
		}
		WQU.print_result(N);
		scan.close();
	}
}