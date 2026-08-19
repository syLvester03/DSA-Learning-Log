package linked_list;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	static Node Insert(Node start, int x) {
		if((start == null) || (start.data > x) ) {
			start = new Node(x, start);
			return start;
		}
		Node p = start;
		while(p.next != null) {
			if(p.next.data > x) {
				break;
			}
			p = p.next;
		}
		p.next = new Node(x, p.next);
		return start;
	}
	
	static Node delete(Node start, int x) {
		if((start == null) || (start.data > x)) {
			return start;
		}
		else if(start.data == x) {
			return start.next;
		}
		for(Node i = start; i.next!=null; i=i.next) {
			if(i.next.data>x) {
				break;
			}
			else if(i.next.data == x) {
				i.next = i.next.next;
				break;
			}
		}
		return start;
	}
	
	static Node replace(Node start, int x, int y) {
		if((start == null) || (start.data > x)) {
			return start; 
		}
		else if(start.data == x) {
			start.data = y;
			return start;
		}
		for(Node i = start; i.next!=null; i=i.next) {
			if(i.next.data>x) {
				break;
			}
			else if(i.next.data == x) { 
				i.next.data = y;
				break;
			}
		}
		return start;
	}
	
	static void print_all(Node s) {
		for(Node i = s; i!=null; i = i.next) {
			System.out.print(i.data + " ");
		}
		System.out.println("");
	}
	
	static Node sublist(Node start, int st, int end) {
		Node sub_list = null;
		for(int i=0; i<end; i++) {
			if(i == st) {
				sub_list = start;
			}
			start = start.next;
		}
		start.next = null; 
		return sub_list; 
	}
	
	static Node merge(Node s1, Node s2) {
		Node s3 = null;
		for(Node i = s1; i!=null; i=i.next) {
			s3 = Node.Insert(s3, i.data);
		}
		for(Node i=s2; i!=null; i = i.next) {
			s3 = Node.Insert(s3, i.data);
		}
		return s3;
	}
	
	static boolean search(Node s, int x) {
		for(Node i=s; i!=null; i=i.next) {
			if(i.data == x) {
				return true;
			}
		}
		return false;
	}
}

public class ll_methods {
	public static void main(String[] args) {
		// Adding data in a linked list
		Node a = new Node(30);
		Node temp = a;
		for(int i=33; i<=60; i+=3) {
			temp.next = new Node(i);
			temp = temp.next;
		}
//		Node.print_all(a);
		
		//Search for element in list
//		System.out.println(Node.search(a, 45));
		
		// Adding data via insert
		Node p = null;
		for(int i = 100; i<1000; i+=100) {
			p = Node.Insert(p,i);
		}
//		p = Node.Insert(p, 50);
//		Node.print_all(p); 
		
		// Merge lists
		Node l1 = null;
		for(int i = 5; i<=30; i+=5) {
			l1 = Node.Insert(l1, i); 
		}
		Node l2 = null;
		for(int i = 4; i<=30; i+=4) {
			l2 = Node.Insert(l2, i); 
		}
		Node l3 = Node.merge(l1,l2);
//		Node.print_all(l1);
//		Node.print_all(l2);
//		Node.print_all(l3);
		
		// Delete element from list
//		Node.print_all(l3);
//		l3 = Node.delete(l3,16);
//		System.out.println("After deletion");
//		Node.print_all(l3);

//		 Replace element in list
//		Node.print_all(l3);
//		l3 = Node.replace(l3, 16, 100); 
//		System.out.println("After replace");
//		Node.print_all(l3);
	
		// Make a sublist
		Node.print_all(l3);
		Node n1 = Node.sublist(l3, 6,9);
		System.out.println("Sub list");
		Node.print_all(n1);
	}	
} 
