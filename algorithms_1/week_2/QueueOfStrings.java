// Warm up example for Storage classes
// QueueOfStrings.java

// Note: this actually scans word by word, not 
//       strings from the input.
//       In order for this to work with sequence
//       of strings, look for comments of the 
//       form //** below and modify it

import java.util.*;

public class QueueOfStrings
{

	private class Node {
		String item;
		Node next;
	}
	private Node first, last;
	
	// constructor
	public QueueOfStrings()
	{
	}
	
	// insert a new string into the queue
	public void enqueue(String item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {
			oldlast.next = last;
		}
	}
	
	// remove a string from the queue
	public String dequeue()
	{
		String item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}
	
	// test if the queue is empty
	public boolean isEmpty()
	{
		return first == null;
	}

	// Client code
	public static void main(String[] args)
	{
		QueueOfStrings queue = new QueueOfStrings();
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