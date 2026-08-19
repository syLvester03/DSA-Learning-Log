package ArraysJava;
class Max {
    public static void main(String[] args) {
        int[] arr = { 20, 33, 45, 98, 29, 87, 26, 99, 786, 3629 };
        System.out.println(maxVal(arr));
    }

    static int maxVal(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
