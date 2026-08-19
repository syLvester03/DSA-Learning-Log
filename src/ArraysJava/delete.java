package ArraysJava;

public class delete {
    public static void main(String[] args){
        int arr[] = {10, 20 , 25 , 30 , 40};
        int arr2[] = new int[4];
        System.arraycopy(arr, 0, arr2, 0, 2);
        System.arraycopy(arr, 3, arr2, 2, 2);

        arr = new int[4];
        
        System.arraycopy(arr2, 0, arr, 0, arr.length);

        arr2 = new int[0];

        for(int i = 0 ; i<arr.length ; i++){

             System.out.println(arr[i]);

        }
                    // System.out.println(arr2[3]);

    }    
}


// Time  O(n)
// Space O(n*2)