package ArraysJava;
public class binarySearch {

    public static int BinarySearch(int[] arr , int target){
        int i = 0; 
        int p = 0;
        int q = arr.length -1;
         while (p<=q) {
            i = (p+q)/2;
            if(arr[i] == target){
                return i ;
            }
            if(arr[i] < target){
                p = i+1;
            }else{
                q = i - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5 ,6 ,7,8,9 ,10 ,11 ,12};
        int target = 12;
        System.out.println(target + " is at index " + BinarySearch(arr , target));

       }
}