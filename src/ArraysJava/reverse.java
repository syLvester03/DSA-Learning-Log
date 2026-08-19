package ArraysJava;
public class reverse {

    public static int[]  reverseArray(int[] arr) {
        int[] copyarray = new int[arr.length];
        System.arraycopy(arr, 0, copyarray, 0, arr.length);
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            --len;
            arr[len] = copyarray[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}