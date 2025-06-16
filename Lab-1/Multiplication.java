import java.util.Arrays;
import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Rows : ");
        int n1 = sc.nextInt();

        System.out.println("Enter Number of Cols : ");
        int m1 = sc.nextInt();

        int[][] arr1 = new int[n1][m1];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.println("Enter Element at arr["+i+"]["+j+"] in arr : ");
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Number of Rows : ");
        int n2 = sc.nextInt();

        System.out.println("Enter Number of Cols : ");
        int m2 = sc.nextInt();

        int[][] arr2 = new int[n2][m2];

        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.println("Enter Element at arr["+i+"]["+j+"] in arr : ");
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] product = new int[n1][m2];


        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int j2 = 0; j2 < m1; j2++) {
                    product[i][j] += arr1[i][j2] * arr2[j2][j];
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(product[i]));
        }
    }
}
