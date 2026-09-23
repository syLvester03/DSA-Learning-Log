package hashTable;

public class LinearProbeHashTable implements Map{
	private class Entry{
		Object key,value; 
		Entry(Object k, Object v){
			this.key = k;
			this.value = v;
		}
	} 
	
	Entry[] entries; 
	int size, used;
	float loadfactor;
	Entry NIL = new Entry(null,null);
	LinearProbeHashTable(int cap, float lf){
		this.entries = new Entry[cap];
		this.loadfactor = lf;
	}
	LinearProbeHashTable(int cap){
		this(cap,0.70F);
	}
	LinearProbeHashTable(){
		this(101);
	} 
	
	
	public int size() {
		return size;
	}
	
	private int hash(Object key) {  
		if(key == null) throw new IllegalArgumentException();
		return((key.hashCode()&0x7FFFFFFF) % this.entries.length); 
	}
	
	private int nextProbe(int h, int i) {
		return (h+i) % this.entries.length; 
	}
	
	private void rehash() {
		Entry[] oldentries = entries;
		entries = new Entry[2*oldentries.length+1];
		for(int i=0; i<oldentries.length; i++) {
			Entry entry = oldentries[i];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key);
			for(int j=0; j<entries.length; j++) {
				int k = nextProbe(h,j);
				if(entries[k] == null) {
					entries[k] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	public Object put(Object key, Object value) {
		if(used > loadfactor*entries.length) rehash();
		int h = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = nextProbe(h,i); 
			Entry entry = entries[j];
			if(entry == null) {
				this.entries[j] = new Entry(key,value);
				size++; used++;
				return null; 
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				Object oldval = entry.value;
				entries[j].value = value;
				return oldval;
			}
		}
		return null; 
	}
	
	public Object get(Object key) {
		int h = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = nextProbe(h,i);  
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL)  continue;
			if(entry.key.equals(key)) return entry.value; 
		}
		return null; 
	}
	
	public Object remove(Object key) {
		int h = hash(key);
		for(int i=0; i<this.entries.length;i++) {
			int j = nextProbe(h,i); 
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) {
				Object temp = entry.value; 
				entries[j] = NIL;
				size--;
				return temp;
			}
		}
		return null; 
	}
	
	public void print_Table() {
		for(int i=0; i<entries.length; i++) {
			if(entries[i] == null) {
				System.out.println(i+": "+"Empty!");
			}
			else {
				System.out.println(i+": "+entries[i].key+"\t"+entries[i].value.toString());
			} 
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
		LinearProbeHashTable ht = new LinearProbeHashTable(13);
		ht.put("PK", c1);ht.put("JPN", c2);ht.put("GR", c3);
		ht.put("CN", c4);ht.put("CA", c5);ht.put("IND", c6);
		ht.put("US", c7);ht.put("FR", c8);ht.put("KSA", c9); 
		ht.put("TR", c10); ht.put("RUS", c11);
		ht.print_Table(); 
	}

}
