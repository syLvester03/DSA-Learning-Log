package lab2;

class methods2{
	
	static int LinearSearch(int[] array, int x) {
		for(int i=0; i<array.length; i++) {
			if(array[i] == x) {					// TIME: O(n), SPACE = O(1)  
				return i;
			}
		}
		return -1;
	}
	
	static int BinarySearch(int[] array, int x) {
		int lb = 0, ub = array.length - 1;
		int mid;			
		while(lb <= ub) {	
			mid = (ub+lb)/2;
			if(array[mid] == x) {				// TIME: O(log n), SPACE: O(1)  
				return mid;						
			} 
			if(array[mid] > x) {
				ub = mid-1; 
			} else {
				lb = mid+1;
			}
		}
		return -1; 
	}
	
}

public class comp {
	public static void main(String[] args) {
		int[] arr = {1,13,25,33,38,42,47,49,51,55,77};
		System.out.println(methods2.BinarySearch(arr, 55));		// TIME O(1)  -> It only prints method's
		System.out.println(methods2.LinearSearch(arr, 55));		// TIME O(1) 	complexity is written above.
	}
}
