package ArraysJava;

public class update {
    public static void main(String[] args) {
        int[] arr = {1,2 ,3 ,4 ,6 , 8 ,9};

        for(int i = 0; i<arr.length ; i++){
            if(arr[i] == 6){
                arr[i] = 5;
            }
            System.out.println(arr[i]);
        }
    }
}

// O(n) Time
// O(1) Space