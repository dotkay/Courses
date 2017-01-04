// Warm up example for Storage classes
// ArrayStackOfStrings.java

// Note: this actually scans word by word, not 
//       strings from the input.
//       In order for this to work with sequence
//       of strings, look for comments of the 
//       form //** below and modify it

import java.util.*;

public class StaticArrayStackOfStrings
{
	private String[] s;
	private int N = 0;
	
	// API
	// constructor
	public StaticArrayStackOfStrings(int capacity)
	{
		s = new String[capacity];
	}

	// push a string into the stack
	public void push(String item)
	{
		s[N++] = item;
	}
	
	// pop a string from the stack
	public String pop()
	{
		String item = s[--N];
		s[N] = null;
		return item;
	}
	
	// test if the stack is empty
	public boolean isEmpty()
	{
		return N == 0;
	}

	// Client code
	public static void main(String[] args)
	{
		StaticArrayStackOfStrings stack = new StaticArrayStackOfStrings(10);
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