package queue;

public interface Queue_req {
	public int size();
	public Object first();
	public void add(Object obj);
	public Object remove();
}
