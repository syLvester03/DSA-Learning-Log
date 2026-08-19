package linked_list;

class pNode{
	int data;
	pNode next;
	
	pNode(int d){
		this.data = d;
		this.next = null;
	}
	
	pNode(int d, pNode n){
		this.data = d;
		this.next = n;
	}
	
	static void print_all(pNode s) {
		for(pNode i = s; i!=null; i = i.next) {
			System.out.print(i.data + " ");
		}
		System.out.println("");
	}
	
	static pNode insert(pNode s, int x) {
		if((s == null) || (s.data > x)) {
			s = new pNode(x, s);
			return s;
		}
		pNode temp = s;
		while(temp.next!=null) {
			if(temp.next.data > x) {
				break;
			}
			temp = temp.next;
		}
		temp.next = new pNode(x, temp.next);
		return s;
	}
	
	static pNode delete(pNode s, int x) {
		if((s == null) || (s.data > x)) {
			return s;
		}
		if((s.data == x)) {
			return s.next;
		}
		pNode temp = s;
		while(temp.next!=null) {
			if(temp.next.data > x) {
				break;
			}
			if(temp.next.data == x) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		} 
		return s;
	}
	
	static pNode replace(pNode s, int x, int y) {
		if((s == null) || (s.data > x)) {
			return s;
		}
		if(s.data == x) {
			s.data = y;
			return s;
		}
		for(pNode i=s; i.next!=null; i=i.next) {
			if(i.next.data > x) {
				break;
			}
			if(i.next.data == x) {
				i.next.data = y;
				break;
			}
		}
		return s;
	}
	
	static pNode sublist(pNode s, int st, int end) {
		pNode sub = null;
		for(int i=0; i<end; i++) {
			if(i==st) {
				sub = s;
			} 
			s = s.next;
		}
		s.next = null;
		return sub;  
	}
	
	static boolean search(pNode s, int x) {
		while(s!=null) {
			if(s.data == x) {
				return true;
			}
			s = s.next;
		}
		return false;
	}
}

public class Practise_ll {
	public static void main(String[] args) {
		pNode l1 = null;
		for(int i = 4; i<=30; i+=4) {
			l1 = pNode.insert(l1, i); 
		}
//		pNode.print_all(l2);
//		l1 = pNode.insert(l1, 34);
//		l1 = pNode.insert(l1, 2);

//		pNode.print_all(l1);
//		l1 = pNode.delete(l1, 24);
//		pNode.print_all(l1);

//		l1 = pNode.replace(l1, 24, 36);
//		pNode.print_all(l1);
//		
//		pNode l2 = pNode.sublist(l1, 2, 4);
//		pNode.print_all(l2); 
		
		System.out.println(pNode.search(l1, 13));
	}
}