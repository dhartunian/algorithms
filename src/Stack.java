import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

	private Node head;
	private int size;
	
	private class Node {
		public Item data;
		public Node next;
	}
	
	public void push(Item data) {
		Node newHead = new Node();
		newHead.data = data;
		newHead.next = this.head;
		this.head = newHead;
		this.size++;
	}
	
	public Item pop() {
		Item data = this.head.data;
		this.head = this.head.next;
		this.size--;
		return data;
	}
	
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	public int size() {
		return this.size;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node listhead = head;
		
		public Item next() {
			Item data = this.listhead.data;
			this.listhead = this.listhead.next;
			return data;
		}
		
		public void remove() {}
		
		public boolean hasNext() {
			return (listhead == null);
		}
				
	}
	
	
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

}
