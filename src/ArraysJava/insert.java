package ArraysJava;
class insert {
    public static void main(String[] args) {
        // int arr[];
        // arr = new int[4];
        int[] arr = { 10, 20, 30, 40 };
        int arr2[] = new int[5];
        System.arraycopy(arr, 0, arr2, 0, 2);
        arr2[2] = 25;
        System.arraycopy(arr, 2, arr2, 3, 2);

        arr = new int[5];
        System.arraycopy(arr2, 0, arr, 0, 5);
        arr2 = new int[0];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

// O(n) Time
// O(n*2) Space