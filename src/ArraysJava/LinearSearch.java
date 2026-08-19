package ArraysJava;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {203, 48 , 36 ,65, 3 ,6 ,35,8};
        System.out.println(linearSearch(arr, 8));
    }

    static int linearSearch(int[] arr, int target){
        int i = 0;
       while(i<arr.length){
        i++;
            if(arr[i]== target){
                return i;
            }
         
        }
        return -1;
    }
}
