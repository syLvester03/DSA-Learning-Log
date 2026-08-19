package stack_extra;

class new_node{
	int data;
	new_node next;
	new_node(int d, new_node n){
		this.data = d;
		this.next = n;
	}
}

class stack_ll{
	private int size;
	private new_node top;
	private new_node track_min;
	private new_node track_max;
	
	private void push_min() {
		if(size == 1) {
			track_min = new new_node(top.data, track_min);
		}else {
			if(track_min.data < top.data) {
				track_min = new new_node(track_min.data, track_min);
			}
			else {
				track_min = new new_node(top.data, track_min);
			}
		}
	}
	
	private void push_max() {
		if(size == 1) {
			track_max = new new_node(top.data, track_max);
		}else {
			if(track_max.data > top.data) {
				track_max = new new_node(track_max.data, track_max);
			}
			else {
				track_max = new new_node(top.data, track_max);
			}
		}
	}
	
	public void push(int obj) {
		top = new new_node(obj, top);
		size++;
		push_min();
		push_max();
	}
	
	private void pop_min() {
		track_min = track_min.next;
	}
	
	private void pop_max() {
		track_max = track_max.next;
	}
	
	public Object pop() {
		if(size == 0) {
			throw new IllegalStateException("Stack is already Empty!") {};
		}
		Object removed_item = top.data;
		top = top.next;
		size--;
		pop_min();
		pop_max();
		return removed_item;
	}
	
	public void print_max() {
		System.out.println(track_max.data);
	}
	public void print_min() {
		System.out.println(track_min.data);
	}
	
	public void print_stack() {
		for(new_node i=top; i!=null; i=i.next) {
			System.out.print(i.data + " ");
		}
		System.out.println();
	}
	public void print_min_stack() {
		for(new_node i=track_min; i!=null; i=i.next) {
			System.out.print(i.data + " ");
		}
		System.out.println();
	}
	public void print_max_stack() {
		for(new_node i=track_max; i!=null; i=i.next) {
			System.out.print(i.data + " ");
		}
		System.out.println();
	}
}

public class Dual_stack_ll {
	public static void main(String[] args) {
		stack_ll s1 = new stack_ll();
		s1.push(33);s1.push(22);s1.push(6);s1.push(38);s1.push(2);s1.push(99);
//		s1.pop();s1.pop();
		s1.print_stack();
		s1.print_max();s1.print_min();
//		s1.print_max_stack();
//		s1.print_min_stack();
	}
}
