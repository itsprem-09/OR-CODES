import java.util.Arrays;
import java.util.Scanner;

public class Additon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Rows : ");
        int n = sc.nextInt();

        System.out.println("Enter Number of Cols : ");
        int m = sc.nextInt();

        int[][] arr1 = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter Element at arr["+i+"]["+j+"] in arr : ");
                arr1[i][j] = sc.nextInt();
            }
        }

        int[][] arr2 = new int[n][m];

        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter Element at arr["+i+"]["+j+"] in arr : ");
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] res = new int[n][m];

        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }
}
