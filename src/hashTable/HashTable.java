package hashTable;

public class HashTable implements Hash_Table{
	private class Entry{
		Object key,value; 
		Entry(Object k, Object v){
			this.key = k;
			this.value = v;
		}
	}
	private Entry[] entries = new Entry[11];
	private int size; 
	
	public int size() {
		return size;
	}
	public int hash(Object key) {  
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
	
	public static void main(String[] args) {
		country c1 = new country("Pakistan", 10000000, "Urdu");
		country c2 = new country("Japan", 125000000, "Japanese");
		country c3 = new country("Germany", 84000000, "German");
		country c4 = new country("China", 1410000000, "Chinese");
		country c5 = new country("Canada", 41000000, "English");
		
		HashTable ht = new HashTable();
		ht.put("PK",c1);
		ht.put("JPN",c2);
		ht.put("GR",c3);
		ht.put("CN",c4);
		ht.put("CA",c5);
		
		System.out.println(ht.get("CN").toString());
		System.out.println(ht.get("GR").toString());
		System.out.println(ht.get("CA").toString());
		System.out.println(ht.get("JPN").toString());
		System.out.println(ht.get("PK").toString());
	}
}