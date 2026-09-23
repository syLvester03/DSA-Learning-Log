package recursion;

class Node{
	int data;
	Node next;
	Node(int d, Node n){this.data=d; this.next=n;}
	public static Node insert(Node s, int x) {
		return new Node(x,s); 
	}
}

public class Recursion {
	 public static int fact(int x) {
		if(x ==1) return 1;
		int temp = 1;
		 for(int i=x; i>0; i--) {
				temp *= i;
		}
		 return temp;
	} 
	public static int factRecursive(int x) {
		if(x==1) {
			return 1;
		}
		return x*factRecursive(x-1);
	}
	
	public static int sumNaturalNumbers(int n) {
		if(n >= 100) return 0;
		return n+sumNaturalNumbers(n+1);
	}
	
	public static int sumOddNumbers(int n) {
		if(n >= 100) return 0;
		return n+sumOddNumbers(n+2);
	}
	
	public static int fibonacci(int n) {
		if(n==0) return 0;
		if(n<3) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	
	// Recursion in Arrays
	public static int printArray(int arr[], int n) {
		if (n == arr.length) return 0;
		System.out.print(arr[n]+" ");
		return printArray(arr, n+1); 	 
	}
	
	public static void printArrayReversed(int arr[], int n) {
		if(n== arr.length) return;
		printArrayReversed(arr, n+1); 
		System.out.print(arr[n]+" ");
	}
	
	public static int print2dArray(int arr[][], int r, int c) {
		if(r == arr.length) return 0;
		System.out.print(arr[r][c]+" ");
		if(c == arr[r].length-1) return print2dArray(arr, r+1, 0); 
		else return print2dArray(arr, r, c+1); 
	}
	
	
	// Recursion in Linked Structure
	public static int printLinkedList(Node n) {
		if(n == null) return 0;
		System.out.print(n.data + " ");
		return printLinkedList(n.next);
	}
	
	public static void printLinkedListReversed(Node n) {
		if(n == null) return;
		printLinkedListReversed(n.next);
		System.out.print(n.data + " ");
	}
	
	public static void PrintArrayOfLinkedList(Node[] arr, int r, Node c) {
		if(r == arr.length) return; 
		System.out.print(c.data + " ");
		if(c.next == null) {
			if(r+1 < arr.length) {
				System.out.println();
				PrintArrayOfLinkedList(arr, r+1, arr[r+1]);
			}
		}
		else PrintArrayOfLinkedList(arr, r, c.next); 
	} 
	
	
	public static void main(String[] args) { 
//		System.out.println(Recursion.factRecursive(5));
		
//		System.out.println(Recursion.sumNaturalNumbers(1));
		
//		float x = System.currentTimeMillis();
//		System.out.println(Recursion.fibonacci(25));
//		float y = System.currentTimeMillis();
//		System.out.println("Time:" + (y-x));  
		
//		int[] array = {10,20,134,34,76,9832,6,32};
//		Recursion.printArray(array,0);
//		System.out.println();
//		Recursion.printArrayReversed(array, 0);
		
//		int[][] arr2d = {
//			    {1,  2,  3,  4,  5,  6,  7,  8,  9, 10},
//			    {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
//			    {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
//			    {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
//			    {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
//			    {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
//			    {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
//			    {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
//			    {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
//			    {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
//			};
//		Recursion.print2dArray(arr2d,0,0); 
		
		
		Node n = null, m = null;
		n = Node.insert(n, 54);n = Node.insert(n, 66);n = Node.insert(n, 90);n = Node.insert(n, 54);
		n = Node.insert(n, 7);n = Node.insert(n, 33);n = Node.insert(n, 21);n = Node.insert(n, 512);
		m = Node.insert(m, 13);m = Node.insert(m, 23);m = Node.insert(m, 76);m = Node.insert(m, 46);
		
//		Recursion.printLinkedList(n);
//		System.out.println();
//		Recursion.printLinkedListReversed(n);
		
		Node[] arr = {n,m};
		Recursion.PrintArrayOfLinkedList(arr, 0, arr[0]); 
	}
}