// ArrayStack.java
// Stack implementation using Arrays
//		- uses Generics
//		- uses Iterable interface
//		- uses array resizing

import java.util.*;

public class ArrayStack<Item> implements Iterable<Item>
{
	private Item[] s;
	private int N = 0;
	
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>
	{
		private int i = N;
		
		public boolean hasNext() 
		{
			return i > 0;
		}
		public void remove()
		{
			// not supported :(
		}
		public Item next()
		{
			return s[--i];
		}
	}

	// API
	// constructor
	public ArrayStack()
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
		ArrayStack<String> stack = new ArrayStack<String>();
		// scanner to get standard input
		Scanner textscan = new Scanner(System.in);
		while (textscan.hasNext()) { //** change to hasNextLine() to work with strings
			String s = textscan.next(); //** change to nextLine() to work with strings
			// if the input string is "-" pop the string from
			// the stack and print it out
			if (s.equals("-")) {
				System.out.format("POP\t %s%n", stack.pop());
			}
			else {
				System.out.format("PUSH\t %s%n", s);
				stack.push(s);
			}
		}
		System.out.println("-----------------------");
		System.out.println("Final Stack:");
		for (String s: stack)
			System.out.println(s);
	}
}