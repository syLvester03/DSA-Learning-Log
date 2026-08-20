package queue;

public class LinkedQueue implements Queue_req{
	private static class Node{
		Object data;
		Node next = this;
		Node previous = this;
		Node(Object d){
			this.data = d;
		}
		Node(Object d, Node n, Node p){
			this.data = d;
			this.next = n;
			this.previous = p;
		}
	}
	private int size;
	private Node head = new Node(null);
	
	public int size() {
		return size;
	}

	public Object first() {
		if(size == 0) {
			throw new IllegalStateException("Queue is Empty!") {};
		}
		return head.next.data;
	} 

	public void add(Object obj) {
		++size;
		head.previous.next = new Node(obj, head, head.previous);
		head.previous = head.previous.next;
	}

	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		LinkedQueue lq = new LinkedQueue();
		lq.add(32);lq.add(56);lq.add(91);
		for(Node i=lq.head.next; i.data!=null; i=i.next) {
			System.out.print(i.data + " ");
		}
	}
}
