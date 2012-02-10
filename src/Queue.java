import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

	private Node head;
	private Node tail;
	private int size;
		
	private class Node {
		public Item data;
		public Node next;
	}

	public void enqueue(Item item) {
		Node newtail = new Node();
		newtail.data = item;
		newtail.next = null;
		if (head == null) {
			this.tail = newtail;
			this.head = newtail;
			this.size = 1;
		} else {
			this.tail.next = newtail;
			this.tail = newtail;
			this.size++;
		}
	}
	
	public Item dequeue() {
		Item mydata = this.head.data;
		this.head = this.head.next;
		size--;
		return mydata;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
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
		Queue<String> q = new Queue<String>();
		
		while(!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
