package hashTable;


public class QuadProbeHashTable implements Map{ 
	private class Entry{
		Object key,value; 
		Entry(Object k, Object v){
			this.key = k;
			this.value = v;
		}
	} 
	
	private Entry[] entries;
	private int size; 
	Entry NIL = new Entry(null,null);
	QuadProbeHashTable(int cap){ 
		this.entries = new Entry[cap];
	}
	
	public int size() {
		return size;
	}
	
	public int hash(Object key) {  
		return((key.hashCode()&0x7FFFFFFF) % this.entries.length); 
	}
	public Object put(Object key, Object value) {
		int index = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = (index+i*i)%this.entries.length;  
			Entry entry = entries[j];
			if(entry == null) {
				this.entries[j] = new Entry(key,value);
				size++;
				return null;
			}
		}
		throw new IllegalStateException("Table full");
	}
	public Object get(Object key) {
		int index = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = (index+i*i)%this.entries.length; 
			Entry entry = entries[j];
			if(entry == null) {
				break;
			}
			if(entry == NIL) { 
				continue;
			}
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null; 
	}
	public Object remove(Object key) {
		int index = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = (index+i*i)%this.entries.length; 
			Entry entry = entries[j];
			if(entry == null) {
				break;
			}
			if(entry == NIL) {
			    continue;
			}
			if(entry.key.equals(key)) {
				Object temp = entry.value; 
				entries[j] = NIL;
				--size;
				return temp;
			}
		}
		return null; 
	}
}
