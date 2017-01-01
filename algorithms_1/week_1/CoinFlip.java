// Warm up exercises
// CoinFlip.java

public class CoinFlip
{

	public class Counter implements Comparable<Counter> {
	
		private final String name;
		private int count = 0;
		
		// constructor
		public Counter(String id)
		{
			name = id;
		}
		
		public void increment() 
		{
			count++;
		}
		
		public int tally()
		{
			return count;
		}
		
		public String toString() 
		{
			return count + " " + name;
		}

	}

	// Client code
	public static void main(String[] args)
	{
		// get the number of coin flips from the command line
		int n = Integer.parseInt(args[0]);
		
		// head and tails counters
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		for (int i = 0; i < n; i++) {
			if (Math.random() > 0.5)
				heads.increment();
			else
				tails.increment();
		}
		System.out.format("heads: %d%n", heads);
		System.out.format("tails: %d%n", tails);
	}
}