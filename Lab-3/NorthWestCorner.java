
import java.util.Arrays;

public class NorthWestCorner {
    public static void main(String[] args) {

        int[][] cost = {
            {12, 10, 12, 13},
            {7, 11, 8, 14},
            {6, 16, 11, 7}
        };

        int[] demand = {180, 150, 350, 320};

        int[] supply = {500, 300, 200};

        int[][] allocation = new int[3][4];

        int total_cost = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (supply[i] > demand[j]) {
                    allocation[i][j] = demand[j];
                    supply[i] -= demand[j];
                    demand[j] = 0;
                }
                else{
                    allocation[i][j] = supply[i];
                    demand[j] -= supply[i];
                    supply[i] = 0;
                    break;
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                total_cost += allocation[i][j] * cost[i][j];
            }
        }

        System.out.println(Arrays.toString(allocation[0]));
        System.out.println(Arrays.toString(allocation[1]));
        System.out.println(Arrays.toString(allocation[2]));

        System.out.println("Total Cost = "+total_cost);
    }
}
