import java.util.Scanner;

public class transpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Rows : ");
        int n = sc.nextInt();

        System.out.println("Enter Number of Cols : ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter Element at arr["+i+"]["+j+"] in arr : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Orignal : ");

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Transpose : ");

         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
        
    }

}