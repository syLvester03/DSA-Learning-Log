package ArraysJava;
import java.util.Arrays;

public class TwoDSearch {
    public static void main(String[] args) {
        int[][] arr= 
        {
            {1 , 3 ,7 },
            {64, 84 , 65},
            {857, 84 , 0 , 54 , 89}
        };
        int[] ans = search(arr, 89);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr , int target){
        for(int i = 0; i<arr.length; i++)
        {
           for(int j = 0 ; j <arr[i].length ; j++){
            if(arr[i][j] == target){
                return new int[]{i , j} ;
            }
           }
        }
        return new int[]{-1 , -1};
    }
}
