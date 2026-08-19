package ArraysJava;
public class subarray {
    public static int[] subArray(int[] arr , int a , int b){
     
       
        for(int i =a ; i<= b ; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 1, 52, 23, 64, 15, 96, 47, 38, 89 };
        int a =2, b=7;
        subArray(arr , a ,  b );
       
    }
}