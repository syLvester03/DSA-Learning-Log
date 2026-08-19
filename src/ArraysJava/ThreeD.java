package ArraysJava;
public class ThreeD {
    public static void main(String[] args) {
        int arr[][][] = {
            {
                { 1, 2,3} ,
                {4 ,5,6} , 
                {7 ,8,9}
            },
            {
                {11 , 22 , 33} ,
                {101 , 202 , 303 , 98} ,
                 {10 , 20 , 30 , 9 , 6}
            },
            {
                {66 , 77 , 88} ,
                {90 , 89 , 78} ,
                 { 34 , 56 , 82}
            },

        };

        for(int i = 0 ; i< arr.length ; i++){
            for(int j = 0 ; j< arr[i].length ; j++){
                for(int k = 0 ; k< arr[i][j].length; k++){
                    System.out.print(arr[i][j][k] + "  ");

                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
