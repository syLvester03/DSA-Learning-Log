package hashTable;

public interface Hash_Table {
	public int size();
	public Object get(Object key);
	public Object put(Object key, Object value);
	public Object remove(Object key);
}
