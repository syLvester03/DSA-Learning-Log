package hashTable;

public class HashTable implements Map{
	private class Entry{
		Object key,value; 
		Entry(Object k, Object v){
			this.key = k;
			this.value = v;
		}
		public String toString() {
			return (key+" = "+(country)value);
		}
	} 
	private Entry[] entries;
	private int size; 
	HashTable(int cap){
		this.entries = new Entry[cap];
	}
	
	public int size() {
		return size;
	}
	private int hash(Object key) {  
		if(key == null) throw new IllegalArgumentException();
		return((key.hashCode()&0x7FFFFFFF) % this.entries.length); 
	}
	public Object get(Object key) {
		return this.entries[hash(key)].value; 
	}
	public Object put(Object key, Object value) {
		this.entries[hash(key)] = new Entry(key, value);
		size++;
		return null; 
	}
	public Object remove(Object key) {
		Object temp = this.entries[hash(key)].value;
		this.entries[hash(key)] = null;
		size--;
		return temp; 
	}
	
	public void print_Table() {
		for(int i=0; i<entries.length; i++) {
			if(entries[i] != null) System.out.println(entries[i].toString());
			else System.out.println("Empty!");
		}
	}
	
	public static void main(String[] args) {
		country c1 = new country("Pakistan", 10000000, "Urdu");
		country c2 = new country("Japan", 125000000, "Japanese");
		country c3 = new country("Germany", 84000000, "German");
		country c4 = new country("China", 1410000000, "Chinese");
		country c5 = new country("Canada", 41000000, "English");
		country c6 = new country("India", 1400000000, "Hindi");
		country c7 = new country("United States", 340000000, "English");
		country c8 = new country("France", 68000000, "French");
		country c9 = new country("Saudi Arabia", 35000000, "Arabic");
		country c10 = new country("Turkey", 86000000, "Turkish");
		country c11 = new country("Russia", 145000000, "Russian");
		HashTable ht = new HashTable(13);
		ht.put("PK", c1);ht.put("JPN", c2);ht.put("GR", c3);
		ht.put("CN", c4);ht.put("CA", c5);ht.put("IND", c6);
		ht.put("US", c7);ht.put("FR", c8);ht.put("KSA", c9); 
		ht.put("TR", c10); ht.put("RUS", c11);
		ht.print_Table(); 
	}
}