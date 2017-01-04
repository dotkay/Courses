// Week-2
// Warm up example for Storage classes
// StackOfStrings.java


// Note: this actually scans word by word, not 
//       strings from the input.
//       In order for this to work with sequence
//       of strings, look for comments of the 
//       form //** below and modify it

import java.util.*;

public class StackOfStrings
{

	// Linked List implementation
	private class Node 
	{
		String item;
		Node next;
	}
	private Node first = null;

	// constructor
	public StackOfStrings()
	{
	}
	
	// API
	// push a string into the stack
	public void push(String item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	// pop a string from the stack
	public String pop()
	{
		String item = first.item;
		first = first.next;
		return item;
	}
	
	// test if the stack is empty
	public boolean isEmpty()
	{
		return first == null;
	}

	// Client code
	public static void main(String[] args)
	{
		StackOfStrings stack = new StackOfStrings();
		// scanner to get standard input
		Scanner textscan = new Scanner(System.in);
		while (textscan.hasNext()) { //** change to hasNextLine() to work with strings
			String s = textscan.next(); //** change to nextLine() to work with strings
			// if the input string is "-" pop the string from
			// the stack and print it out
			if (s.equals("-")) {
				System.out.println(stack.pop());
			}
			else {
				stack.push(s);
			}
		}
	}

}