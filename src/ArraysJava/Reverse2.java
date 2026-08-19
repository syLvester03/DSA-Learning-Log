package ArraysJava;
import java.util.Arrays;

public class Reverse2 {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3 ,4 , 5, 6, 7 ,8 ,9 , 10};
        reverse(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void reverse(int[] arr ){
        int  end = arr.length-1;
        int start =0 ;
        for(int i = 0 ; i <= end ; i++ ){
            int temp = arr[start];

            arr[start] = arr[end];
            
            arr[end] = temp;
            end --;
            start ++;
            if(start > end ){
               
                break;
            }
            
        }

    }
}
