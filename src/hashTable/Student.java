package hashTable;

public class Student {
	private String name, dept, programme, phone, cnic;
	private int age, year, batch;
	Student(String n, int a, String d, String pr, String ph, String c, int y, int b){
		this.name = n; this.dept = d; this.programme = pr; this.phone = ph; this.cnic = c;
		this.age = a; this.year = y; this.batch = b;
	}
	public String toString() {
	    StringBuffer temp = new StringBuffer("");
	    temp.append("Name: " + this.name + " ");
	    temp.append("Age: " + this.age + " ");
	    temp.append("Department: " + this.dept + " ");
	    temp.append("Programme: " + this.programme + " ");
	    temp.append("Year: " + this.year + " ");
	    temp.append("Batch: " + this.batch+ " ");
	    temp.append("Phone: " + this.phone + " ");
	    temp.append("CNIC: " + this.cnic);
	    return temp + " ";
	}

}
