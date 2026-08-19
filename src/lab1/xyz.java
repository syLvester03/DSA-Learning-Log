package lab1;

class methods{
	
	static int[] sort(int[] array) {
		int temp = 0;
		for(int i=0; i<array.length;i++) {
			for(int j=0; j<array.length-1; j++) {		// TIME: O(n^2)
				if(array[j] > array[j+1]) {				// SPACE O(1)    
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	static int sum(int[] array) {
		int sum = 0;
		for(int i=0; i < array.length; i++) { 
			sum += array[i];   						// TIME: O(n),  SPACE: O(1)  
		}
		return sum;
	}
	
	static float avg(int[] array, int sum) {
		return ((float)sum / array.length);       // TIME: O(1),  SPACE: O(1)  
	}
	
	static int mid_element(int[] array) {
		return array[(int)(array.length / 2)];    // TIME: O(1),  SPACE: O(1)  
	}
}

public class xyz {
	public static void main(String[] args) {
		int[] arr = {1,45,23,68,81,52,41,74,87};  // SPACE: O(n)  
		
		int sum = methods.sum(arr);				// SPACE: O(1)
		float avg = methods.avg(arr, sum);		// SPACE: O(1)
		System.out.println("Sum of numbers: " + sum + "\nAvera1ge of numbers: " + avg); // TIME: O(1)
		
		arr = methods.sort(arr);				// SPACE O(1)
		for(int i=0; i<arr.length; i++) {	
			System.out.print(arr[i] + " "); 	// TIME: O(n) 
		}
		System.out.println("");					// TIME: O(1) 
		
		System.out.println(methods.mid_element(arr));	// TIME: O(1) 
	}
}
