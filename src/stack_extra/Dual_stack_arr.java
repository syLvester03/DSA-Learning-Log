package stack_extra;

class stack_arr{
	private int size;
	private int a[];
	private int track_min[];
	private int track_max[];
	stack_arr(int s){
		a = new int[s];
		track_min = new int[s];
		track_max = new int[s];
	}
	
	private int[] resize(int arr[]) {
		int[] aa = arr;
		arr = new int[2*aa.length];
		System.arraycopy(aa, 0, arr, 0, size);
		return arr;
	}
	private void push_min() {
		if(size == 1) {
			track_min[0] = a[0];
		}
		else {
			if(a[size-1] < track_min[size-2]) {
				track_min[size-1] = a[size-1];
			} 
			else{
				track_min[size-1] = track_min[size-2];
			}
		}
	}
	private void push_max() {
		if(size == 1) {
			track_max[0] = a[0];
		}
		else {
			if(a[size-1] > track_max[size-2]) {
				track_max[size-1] = a[size-1];
			} 
			else{
				track_max[size-1] = track_max[size-2];
			}
		}
	}
	public void push(int obj) {
		if(size == a.length) {
			a = resize(a);
			track_min = resize(track_min);
			track_max = resize(track_max);
		}
		a[size++] = obj;
		push_min();
		push_max();
	}
	private void pop_min() {
		track_min[size] = 0;
	}
	private void pop_max() {
		track_max[size] = 0;
	}
	public int pop() {
		if(size == 0) {
			throw new IllegalStateException("Stack is already Empty!") {};
		}
		int temp = a[--size];
		a[size] = 0;
		pop_min();
		pop_max();
		return temp; 
	}
	public void print_min() {
		System.out.println(track_min[size-1]);
	}
	public void print_max() {
		System.out.println(track_max[size-1]);
	}
	public void print_stack() {
		if(size != 0) {
			for(int i=size-1; i>=0; i--) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("Stack is Empty!");
		}
	}
	public void print_min_stack() {
		if(size != 0) {
			for(int i=size-1; i>=0; i--) {
				System.out.print(track_min[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("Min Stack is Empty!");
		}
	}
	public void print_max_stack() {
		if(size != 0) {
			for(int i=size-1; i>=0; i--) {
				System.out.print(track_max[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("Max Stack is Empty!");
		}
	}
	public void print_size() {
		System.out.println(size);
	}  
	
}
public class Dual_stack_arr {
	public static void main(String[] args) {
		stack_arr s1 = new stack_arr(100);
		s1.push(15);s1.push(98);
		s1.push(67);s1.push(12);
		s1.push(52);s1.push(101);
		
//		s1.print_stack();
//		s1.print_size();
//		s1.print_min();
//		s1.print_max();
		
//		s1.pop();s1.pop();
//		s1.pop();s1.pop();
//		s1.pop();s1.pop();
		
		s1.print_stack();
		s1.print_max();s1.print_min();
//		s1.print_min_stack();
//		s1.print_max_stack();
		
		}
}
