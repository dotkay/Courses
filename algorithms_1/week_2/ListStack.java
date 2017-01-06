// ListStack.java
// Stack implementation using LinkedList
//		- uses Generics
//		- uses Iterable interface

import java.util.*;

public class ListStack<Item> implements Iterable<Item>
{
	
	private Node first;
	
	private class Node
	{
		Item item;
		Node next;
	}

	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node curr = first;
	
		public boolean hasNext()
		{
			return (curr != null);
		}
		public void remove()
		{
			// not supported :(
		}
		public Item next()
		{
			Item item = curr.item;
			curr = curr.next;
			return item;
		}
	}
	
	// API
	// constructor
	public ListStack() 
	{
		first = null;
	}
	
	// push an item into the stack
	public void push(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	// pop an item from the stack
	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	// test if the stack is empty
	public boolean isEmpty()
	{
		return (first == null);
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