public class Maximization {

    public static void main(String[] args) {
        int max = -1;
        int sum = 0;
        int value_x1 = 0;
        int value_x2 = 0;

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if ((i + j) <= 4 ) {
                    sum = 3 * i + 2 * j;
                    if ( sum > max  ) {
                        max = sum;
                        value_x1 = i;
                        value_x2 = j;
                    }
                }
            }
        }

        System.err.println("x = "+value_x1+" y = "+value_x2+" and z = 3x1 + 3x2 = "+sum);
    }
}
