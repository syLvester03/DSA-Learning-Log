package hashTable;

public class ChainedHashTable implements Map{
	private class Entry{
		Object key,value;
		Entry next;
		Entry(Object k, Object v, Entry n){
			this.key = k;
			this.value = v;
			this.next = n;
		}
		public String toString() {
			return key+" = "+(Student)value; 
		}
	}
	
	private Entry[] entries;
	private int size;
	private float loadfactor;
	
	ChainedHashTable(int cap, float lf){
		this.entries = new Entry[cap];
		this.loadfactor = lf;
	}
	ChainedHashTable(int cap){
		this(cap,0.75F);
	}
	ChainedHashTable(){
		this(101);
	}
	
	public int size() {
		return size;
	}

	private int hash(Object key) {  
		return((key.hashCode()&0x7FFFFFFF) % this.entries.length); 
	}
	
	public Object get(Object key) {
		int h = hash(key);
		for(Entry e = entries[h]; e!=null; e=e.next) {
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null; 
	}
	
	private void rehash() {
		Entry[] oldentries = entries;
		entries = new Entry[2*oldentries.length];
		for(int i=0; i<oldentries.length; i++) {
			for(Entry old=oldentries[i]; old!=null;) {
				Entry e = old;
				old = old.next;
				int h = hash(e.key);
				e.next = entries[h];
				entries[h] = e;
			}
		}
	}

	public Object put(Object key, Object value) {
		int h = hash(key);
		for(Entry e = entries[h]; e!=null; e=e.next) {
			if(e.key.equals(key)) {					// If the same key already exists update value
				Object oldval = e.value;
				e.value = value;
				return oldval; 
			}
		}
		entries[h] = new Entry(key,value,entries[h]);	// put if it does not exist
		size++;
		if(size > loadfactor*entries.length) {
			rehash();
		}
		return null;
	}

	public Object remove(Object key) {
		int h = hash(key);
		for(Entry e=entries[h] ,prev=null; e!=null; prev=e, e=e.next) {
			if(e.key.equals(key)) {
				Object oldval = e.value;
				if(prev==null) {
					entries[h] = e.next;
				}
				else {
					prev.next = e.next;
				}
				size--;
				return oldval;
			}
		}
		return null;
	}
	
	public void printTable() {
		for(int i=0; i<this.entries.length; i++) {
			if(entries[i] == null) {
				System.out.println(i+": Empty!");
			}
			else {
				for(Entry e=entries[i]; e!=null; e=e.next) {
					System.out.println(i+": "+e.toString());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Object[][] Students = {
		{"25BSAI011", new Student("Hasnain", 21, "SW", "AI", "0300-3135237", "41306-0764424-7", 2, 25)},
		{"25BSAI012", new Student("Ahmed", 20, "CS", "AI", "0301-4567890", "41306-1234567-1", 2, 25)},
		{"25BSAI013", new Student("Ali", 21, "SW", "AI", "0302-5678901", "41306-2345678-2", 2, 25)},
		{"25BSAI014", new Student("Hassan", 20, "CSE", "AI", "0303-6789012", "41306-3456789-3", 2, 25)},
		{"25BSAI015", new Student("Usman", 22, "EE", "AI", "0304-7890123", "41306-4567890-4", 2, 25)},
		{"25BSAI016", new Student("Hamza", 20, "SW", "AI", "0305-8901234", "41306-5678901-5", 2, 25)},
		{"25BSAI017", new Student("Zain", 21, "CS", "AI", "0306-9012345", "41306-6789012-6", 2, 25)},
		{"25BSAI018", new Student("Saad", 20, "CSE", "AI", "0307-0123456", "41306-7890123-7", 2, 25)},
		{"25BSAI019", new Student("Bilal", 21, "SW", "AI", "0308-1234567", "41306-8901234-8", 2, 25)},
		{"25BSAI020", new Student("Talha", 22, "CS", "AI", "0309-2345678", "41306-9012345-9", 2, 25)},
		{"25BSAI021", new Student("Fahad", 20, "CSE", "AI", "0310-3456789", "41306-0123456-0", 2, 25)}
			};
		ChainedHashTable cht = new ChainedHashTable(15,0.9F);
		for(int i=0; i<Students.length; i++) {
			cht.put(Students[i][0], Students[i][1]);
		}
//		System.out.println(cht.get(Students[6][0]).toString());
		cht.printTable();
		
	}
	
}
