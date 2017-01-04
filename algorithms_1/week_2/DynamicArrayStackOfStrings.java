// Warm up example for Storage classes
// DynamicArrayStackOfStrings.java

// Note: this actually scans word by word, not 
//       strings from the input.
//       In order for this to work with sequence
//       of strings, look for comments of the 
//       form //** below and modify it

import java.util.*;

public class DynamicArrayStackOfStrings
{

	private String[] s;
	private int N = 0;
	
	// API
	// constructor
	public DynamicArrayStackOfStrings()
	{
		// we will start with an array of size 1
		// we will repeatedly double the array
		// everytime it gets filled up
		s = new String[1];
	}
	
	// push a string into the stack
	public void push(String item)
	{
		// if the stack is full, resize the stack
		if (N == s.length) {
			resize(2 * s.length);
		}
		s[N++] = item;
	}
	
	// pop a string from the stack
	public String pop()
	{
		String item = s[--N];
		s[N] = null;
		// if the array is 1/4 full after the deletion, then 
		// resize it to 1/2 of the original size
		if (N > 0 && N == s.length/4) {
			resize(s.length / 2);
		}
		return item;
	}
	
	// test if the stack is empty
	public boolean isEmpty() 
	{
		return N == 0;
	}

	// helper function - resize the array
	private void resize(int capacity) 
	{
		// create a new array (of resized capacity); 
		// copy over the elements from s into it.
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	// Client code
	public static void main(String[] args)
	{
		DynamicArrayStackOfStrings stack = new DynamicArrayStackOfStrings();
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