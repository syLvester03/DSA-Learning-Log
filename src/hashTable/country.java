package hashTable;

public class country {
	private String name;
	private int population;
	private String language;
	country(String n, int p, String l){
		this.name = n;
		this.population = p;
		this.language = l;
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("");
		temp.append("Name: "+this.name+" ");
		temp.append("Pop: "+this.population+" ");
		temp.append("Lang: "+this.language+" "); 
		return temp+" "; 
	}
}
