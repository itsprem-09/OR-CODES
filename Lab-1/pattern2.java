public class pattern2 {
    public static void main(String[] args) {
        int n = 5;

        int t = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                if (j <= (n / 2)) {
                    System.out.print(t+" ");
                    t++;
                }
                System.out.print(t+" ");
                t--;
            }
            System.out.println();
        }
    }
}
