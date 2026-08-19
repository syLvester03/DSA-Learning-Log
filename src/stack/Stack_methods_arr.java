package stack;

class ArrayStack implements Stack_req{
	private int size;
	private Object a[];   // Attributes 
	
	ArrayStack(int len){
		this.a = new Object[len];  // Constructor to define array length
	}
	
	private void resize_arr() {
		Object[] aa = a;
		a = new Object[2*aa.length];
		System.arraycopy(aa, 0, a, 0, size); 
	}
	
	public void push(Object obj) {
		if(size == a.length) {
			resize_arr();
		}
		a[size++] = obj; 
//		System.out.println("Item Added!");
	}

	public Object pop() {
		if(size == 0) {
			throw new IllegalStateException("Stack is already Empty!") {};
		}
		Object removed_element = a[--size];
		a[size] = null;
		return removed_element; 
	}

	public Object peek() {
		if(size == 0) {
			throw new IllegalStateException("Array is Empty!") {};
		}
		return a[size-1];
	}
	
	public Object peek_bottom() {
		return a[0];
	}
	
	public Object peek_mid() {
		return a[size/2];
	}
	
	public Object[] reverse() {
		Object[] temp = new Object[a.length];
		int j = 0;
		for(int i=size-1; i>=0; i--) {
			temp[j++] = a[i]; 
		}
		for(int i=size-1; i>=0; i--) {
			System.out.print(temp[i] + " ");
		}
		return temp;
	}
	
	public int size() {
		return size;
	}

	public boolean isempty() {
		return (size == 0);
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("");
		for(int i=size-1; i>=0; i--) {
			temp.append(a[i]);
			temp.append(" ");
		}
		return (temp+" ");		// " " at the end to convert from StringBuffer to String
	}
	
	public LinkedStack toLinkedStack() {
		LinkedStack x = new LinkedStack();
		for(int i=0; i<this.size; i++) {
			x.push(this.a[i]);
		}
		return x;
	}
	
	public ArrayStack[] Divide_Stack() {
		ArrayStack sub_1 = new ArrayStack(size/2);
		ArrayStack sub_2 = new ArrayStack(size/2);
		for(int i=0; i<size; i++) {
			if(i<size/2) {
				sub_1.push(a[i]);
			}
			else {
				sub_2.push(a[i]); 
			}
		}
		ArrayStack[] temp = {sub_1, sub_2};
		return temp;
	}
	
	public static ArrayStack Merge_stack(ArrayStack x, ArrayStack y) {
		ArrayStack merged = new ArrayStack(x.size*2); 
		for(int i=x.size-1; i>=0; i--) {
			merged.push(x.a[i]); 
		}
		for(int i=y.size-1; i>=0; i--) {
			merged.push(y.a[i]);
		}
		return merged; 
	}
	
	public boolean Equals(ArrayStack as) {
		if(this.size != as.size) {
			return false;
		}
		for(int i=0; i<size; i++) {
			if(!this.a[i].equals(as.a[i])) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayStack Copy_Stack() {
		ArrayStack new_stack = new ArrayStack(this.size);
		for(int i=0; i<size; i++) {
			new_stack.push(a[i]); 
		}
		return new_stack; 
	}
	
	
}

public class Stack_methods_arr {
	public static void main(String[] args) {
		int arr[] = {12,45,87,41,74,96,41,14,74,85,14,747};
		ArrayStack s1 = new ArrayStack(arr.length + 10);
		ArrayStack s2 = new ArrayStack(arr.length+10);
		for(int i=0; i<arr.length; i++) {
			s1.push(arr[i]);
			s2.push(arr[i]);
		}
//		s2.pop();
//		System.out.println(s1.Equals(s2));
//		System.out.println(s1.size());
//		System.out.println(s1.toString());
//		s1.pop();
//		s1.pop();
//		s1.print_stack();
//		s1.toString();
//		System.out.println(s1.size());
//		System.out.println(s1.peek());
//		System.out.println(s1.peek_bottom());
//		System.out.println(s1.peek_mid());
//		s1.reverse();
//		LinkedStack ls = s1.toLinkedStack();
//		System.out.println(ls.toString());
		
		ArrayStack[] ax = s1.Divide_Stack();
		System.out.println(ax[0].toString());
		System.out.println(ax[1].toString());
		ArrayStack a = ArrayStack.Merge_stack(ax[0], ax[1]);
		System.out.println(a.toString());

	}
}

