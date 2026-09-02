package queue;

public class ArrayQueue implements Queue_req{
	private int size;
	private Object[] a;
	
	ArrayQueue(int len){
		if(len>0) {
			this.a = new Object[len];
		}
	}
	
	public int size() {
		return size;
	}

	public Object first() {
		if(size == 0) {
			throw new IllegalStateException("Queue is Empty!");
		} 
		return a[0];
	}
	
	private void resize() {
		Object[] aa = a;
		a = new Object[2*aa.length];
		System.arraycopy(aa, 0, a, 0, size); 
	}
	public void add(Object obj) {
		if(size == a.length) {
			resize();
		}
		a[size++] = obj;
	}

	public Object remove() {
		if(size == 0) {
			throw new IllegalStateException("Queue Already Empty!");
		}
		Object to_ret = a[0];
		for(int i=0; i<size-1; i++) {
			a[i] = a[i+1];
		}
		a[--size] = null;
		return to_ret;
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("");
		for(int i=0; i<size; i++) {
			temp.append(a[i]);
			temp.append(" ");
		}
		return temp+" ";
	}
	
	public LinkedQueue toLinkedQueue() {
		LinkedQueue lq = new LinkedQueue();
		for(int i=0; i<size; i++) {
			lq.add(a[i]);
		}
		return lq;
	}
	
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(2);
		aq.add(45);aq.add(31);aq.add(126);aq.add(67);
		System.out.println(aq.toString());
//		aq.remove();aq.remove(); // aq.remove();aq.remove();
//		System.out.println(aq.toString());
		
		LinkedQueue x = aq.toLinkedQueue();
		System.out.println(x.toString());
	}
	
}
