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
		if(size == 0) {
			throw new IllegalStateException("Queue is already Empty!") {};
		}
		--size;
		Object temp = head.next.data;
		head.next = head.next.next;
		head.next.previous = head; 
		return temp; 
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("");
		for(Node i=this.head.next; i!=head; i=i.next) {
			temp.append(i.data); 
			temp.append(" ");
		}
		return temp + " "; 
	} 
	
	public Object[] toArray() {
		Object[] a = new Object[size];
		int index = 0;
		for(Node i=this.head.next; i!=head; i=i.next) {
			a[index++] = i.data;
		}
		return a; 
	}
	
	public Object[] nRearElements(int n) {
		if(n>size || n<1) {
			return new Object[] {null};
		} 
		Object[] a = new Object[n];
		Node temp = this.head.previous;
		for(int i=0; i<n; i++) {
			a[i] = temp.data;
			temp = temp.previous;
		}
		return a;
	}
	
	public static void main(String[] args) {
		LinkedQueue credit = new LinkedQueue();
		LinkedQueue debit = new LinkedQueue();
		credit.add(300);credit.add(1000);credit.add(500);credit.add(750);credit.add(200);
		debit.add(230);debit.add(700);debit.add(320);debit.add(570);debit.add(190);
		
		System.out.println("Credit: "+credit.toString());
		System.out.println("Debit: "+debit.toString());
//		debit.remove();debit.remove();debit.remove();debit.remove();
//		System.out.println("Debit: "+debit.toString());
		
		int size = credit.size();
		int sum_deb = 0, sum_cred=0;
		while(size!=0) {
			int cred = (int)credit.remove();
			sum_cred += cred; 
			size--;
		}
		
		size = debit.size();
		while(size!=0) {
			int deb = (int)debit.remove();
			sum_deb += deb;
			size--;
		}
		
		System.out.println("Total Credit: " + sum_cred);
		System.out.println("Total Debit: " + sum_deb);
		System.out.println("Balanace: " + (sum_cred - sum_deb));
		
		
//		Object[] cred_arr = credit.toArray();
//		for(int i=0; i<cred_arr.length; i++) {
//			System.out.print(cred_arr[i] + " ");
//		}
		
//		Object[] cred_rear = credit.nRearElements(4);
//		System.out.print("Bottom "+cred_rear.length+" elements: ");
//		for(int i=0; i<cred_rear.length; i++) {
//			System.out.print(cred_rear[i] + " ");
//		} 
		
	}
}
