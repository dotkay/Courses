// GenericListStack.java
// Stack implemented using Lists

import java.util.*;

public class GenericListStack<Item>
{
	private Node first;
	private class Node
	{
		Item item;
		Node next;
	}

	// API
	// constructor
	public GenericListStack()
	{
		first = null;
	}
	
	// push an item into the stack
	public void push (Item item)
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
		GenericListStack<String> stack = new GenericListStack<String>();
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