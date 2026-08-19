package linked_list;

class Student{
	String name, phone, cnic, roll_no;
	
	Student(String n, String p, String c, String r){
		this.name = n;
		this.phone = p;
		this.cnic = c;
		this.roll_no = r;
	}
}

class st_node{
	Student data;
	st_node next;
	
	st_node(Student d){
		this.data = d;
		this.next = null;
	}
	
	static void print_all(st_node s) {
		for(st_node i = s; i!=null; i = i.next) {
			System.out.println(i.data.name+" "+i.data.phone+" "+i.data.cnic+" "+i.data.roll_no);
		}
	}
	
	static boolean search_str(st_node s, String val) {
		while(s.next!=null) {
			if(s.data.name.equalsIgnoreCase(val)) {
				System.out.println("Found in name" );
				return true;
			}
			else if(s.data.phone.equalsIgnoreCase(val)) {
				System.out.println("Found in phone");
				return true;
			}
			else if(s.data.cnic.equalsIgnoreCase(val)) {
				System.out.println("Found in cnic");
				return true;
			}
			else if(s.data.roll_no.equalsIgnoreCase(val)) {
				System.out.println("Found in roll_no");
				return true;
			}
			s = s.next;
		}
		System.out.println("Not Found");
		return false;
	}
}

public class st_ll {
	public static void main(String[] args) {
		Student[] list_of_st = {
			new Student("Hasnain", "0300-3135237", "41306-0764424-7", "25BSAI011"),
			new Student("Muzamil", "0301-4567890", "42101-1234567-1", "25BSAI036"),
			new Student("Sajjad", "0302-5678901", "42201-2345678-2", "25BSAI020"),
			new Student("Abdullah", "0303-6789012", "42301-3456789-3", "25BSAI010"),
			new Student("Fatima", "0304-7890123", "42401-4567890-4", "25BSAI015"),
			new Student("Zain", "0305-8901234", "42501-5678901-5", "25BSAI016"),
			new Student("Hira", "0306-9012345", "42601-6789012-6", "25BSAI017"),
			new Student("Bilal", "0307-0123456", "42701-7890123-7", "25BSAI018"),
			new Student("Maryam", "0308-1234567", "42801-8901234-8", "25BSAI019"),
			new Student("Usman", "0309-2345678", "42901-9012345-9", "25BSAI042")
		};
		st_node a = new st_node(list_of_st[0]);
		st_node temp = a;
		for(int i=1; i<list_of_st.length; i++) {
			temp.next = new st_node(list_of_st[i]);
			temp = temp.next;
		}
//		st_node.print_all(a);
		st_node.search_str(a, "42801-8901234-8"); 
	}
}
 