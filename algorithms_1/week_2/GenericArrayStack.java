// GenericArrayStack.java
// Stack implemented using Generics

import java.util.*;

public class GenericArrayStack<Item>
{
	private Item[] s;    // array of items
	private int N = 0;   // number of items in the array
	
	// API
	// constructor
	public GenericArrayStack()
	{
		s = (Item[]) new Object[1];
	}
	
	// push an item into the stack
	public void push(Item item)
	{
		if (N == s.length) {
			resize(s.length * 2);
		}
		s[N++] = item;
	}
	
	// pop an item from the stack
	public Item pop()
	{
		Item item = s[--N];
		s[N] = null;
		// shrink the array if needed
		if (N > 0 && N == s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	
	// test if the stack is empty
	public boolean isEmpty()
	{
		return (N == 0);
	}
	
	// helper function - to resize the array
	private void resize(int capacity)
	{
		// Java does not allow generic array creation
		// so we need to overcome it using type-casting
		// - create an array of type Object
		// - type-cast it to an array of type Item
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	// Client code
	public static void main(String[] args)
	{
		GenericArrayStack<String> stack = new GenericArrayStack<String>();
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