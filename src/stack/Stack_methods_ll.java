package stack;

class Node {
	Object data;
	Node next;
	
	Node(Object d, Node n){
		this.data = d;
		this.next = n;
	}
}

class LinkedStack implements Stack_req{
	private int size;
	private Node top;
	
	public void push(Object obj) {
		top = new Node(obj, top);
		size++;
	}

	public Object pop() {
		if(size == 0) {
			throw new IllegalStateException("Stack is already Empty!") {};
		}
		Object removed_item = top.data;
		top = top.next;
		size--;
		return removed_item;
	}

	public int size() {
		return (size);
	}

	public Object peek() {
		if(size == 0) {
			throw new IllegalStateException("Stack is Empty!") {};
		}
		return top.data;
	}
	
	public Object peek_bottom() {
		Node temp = top;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public Object peek_mid() {
		Node temp = top;
		for(int i=0; i<size/2; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public Node reverse() {
		Object[] list = new Object[size];
		Node temp = top;
		for(int i=0; i<size; i++) {
			list[i] = temp.data;			// copy stack into array
			temp = temp.next;
		}
		for(int i=0; i<size; i++) {
			temp = new Node(list[i], temp);		// assign array back to the stack in reverse order
		}
		for(Node i=temp; i!=null; i=i.next){
			System.out.print(i.data + " "); 
		}
		return temp;
	}
	
	public void reverse_org() {
		Object[] list = new Object[size];
		Node temp = top;
		for(int i=0; i<size; i++) {
			list[i] = temp.data;
			temp = temp.next;
		}
		top = null;
		for(int i=0; i<size; i++) {
			top = new Node(list[i], top);
		}
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("");
		for(Node i=top; i!=null; i=i.next) {
			temp.append(i.data);
			temp.append(" ");
		}
		return temp+" ";
	}
	
	public ArrayStack toArrayStack() {
		ArrayStack x = new ArrayStack(this.size);  // this.size() as well
		for(Node i=this.top; i!=null; i=i.next) {
			x.push(i.data);
		}
		ArrayStack y = new ArrayStack(x.size());
		for(int i=0;i<this.size();i++) {
			y.push(x.pop());
		} 
		return y; 
	}
	
	public LinkedStack[] Divide_stack() {
		LinkedStack sub_1 = new LinkedStack();
		LinkedStack sub_2 = new LinkedStack();
		int x = 0;
		for(Node i=top; i!=null; i=i.next) {
			if(x++<size/2) {
				sub_1.push(i.data);
			}
			else {
				sub_2.push(i.data);
			}
		}
		LinkedStack[] temp = {sub_1, sub_2};
		return temp;
	}
	
	public LinkedStack merge_stack(LinkedStack x, LinkedStack y) {
		LinkedStack merged = new LinkedStack();
		for(Node i=x.top; i!=null; i=i.next) {
			merged.push(i.data);
		}
		for(Node j=y.top; j!=null; j=j.next) {
			merged.push(j.data);
		}
		return merged; 
	}
	
	public boolean Equals(LinkedStack ls) {
		if(this.size != ls.size()) {
			return false;
		}
		Node j = ls.top;
		for(Node i=top; i!=null; i=i.next) {
			if(!i.data.equals(j.data)) {
				return false;
			} 
			j = j.next; 
		}
		return true; 
	}
}

public class Stack_methods_ll {
	public static void main(String[] args) {
		LinkedStack s1 = new LinkedStack();
		int[] arr = {12,45,87,41,74,96,41,14,76};
		for(int i=0; i<arr.length; i++) { 
			s1.push(arr[i]);
		}
//		System.out.println(s1.toString());
//		s1.reverse_org();
//		s1.print_stack();
//		System.out.println(s1.peek());
//		System.out.println(s1.peek_bottom());
//		System.out.println(s1.peek_mid()); 
//		ArrayStack as = s1.toArrayStack();
//		System.out.print(as.toString());
		LinkedStack s2 = s1;
		System.out.println(s1.Equals(s2));
//		LinkedStack[] xx = s1.Divide_stack();
//		System.out.println(xx[0].toString());
//		System.out.println(xx[1].toString());
	}
}
