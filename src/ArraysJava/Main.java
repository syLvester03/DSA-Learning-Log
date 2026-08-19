package ArraysJava;
class Student {
    String rollNo;
    String name ;
    int batch = 25 ;
    
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Umama";
        s.rollNo = "25BSAI030";
        System.out.println(s.name + " " + s.rollNo + " " + s.batch + " ");
        Student s1 = new Student();
        s1.name = "Ajwa";
        s1.rollNo = "25BSAI008";
        System.out.println(s1.name + " " + s1.rollNo + " " + s1.batch + " ");
        Student s2 = new Student();
        s2.name = "Hafsa";
        s2.rollNo = "25BSAI032";
        System.out.println(s2.name + " " + s2.rollNo + " " + s2.batch + " ");

    }
}