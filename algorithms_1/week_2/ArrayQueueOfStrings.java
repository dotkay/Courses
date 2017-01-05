// Warm up example for Storage classes
// ArrayQueueOfStrings.java

// Note: this actually scans word by word, not 
//       strings from the input.
//       In order for this to work with sequence
//       of strings, look for comments of the 
//       form //** below and modify it

import java.util.*;

public class ArrayQueueOfStrings 
{

	private String[] q;
	private int N = 0;
	private int head, tail;	
	// API
	// constructor
	public ArrayQueueOfStrings()
	{
		q = new String[1];
		head = 0;
		tail = 0;
	}
	
	// insert an element into the queue
	public void enqueue(String item)
	{
		// if the queue is full, resize the queue
		if (N == q.length) {
			resize(2 * q.length);
		}
		q[tail] = item; // insert the item
		tail++;         // incr the tail ptr
		N++;            // incr number of items in the queue
	}
	
	// remove an element from the queue
	public String dequeue()
	{
		String item = q[head];
		head++;
		N--;
		// shrink the queue if needed
		if (N > 0 && N == q.length/4) {
			resize(q.length / 2);
		}
		return item;
	}
	
	// to test if the queue is empty
	public boolean isEmpty()
	{
		return (N == 0);
	}

	// helper function for resizing the array
	private void resize(int capacity)
	{
		// create a new array (of resized capacity)
		// copy over the contents into the new array
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = q[i];
		}
		q = copy;
		head = 0;
		tail = N;
	}

	// Client code
	public static void main(String[] args)
	{
		ArrayQueueOfStrings queue = new ArrayQueueOfStrings();
		// scanner to get standard input
		Scanner textscan = new Scanner(System.in);
		while (textscan.hasNext()) { //** change to hasNextLine() to work with strings
			String s = textscan.next(); //** change to nextLine() to work with strings
			// if the input string is "-" dequeue the string from
			// the queue and print it out
			if (s.equals("-")) {
				System.out.println(queue.dequeue());
			}
			else {
				queue.enqueue(s);
			}
		}
	}
}