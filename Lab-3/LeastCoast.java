import java.util.Arrays;

public class LeastCoast {
    public static void main(String[] args) {
        int[][] cost = {
                { 12, 10, 12, 13 },
                { 7, 11, 8, 14 },
                { 6, 16, 11, 7 }
        };

        int[] demand = { 180, 150, 350, 320 };

        int[] supply = { 500, 300, 200 };

        int[][] allocation = new int[3][4];

        int total_cost = 0;

        int total_supply = sumOfArray(supply);
        int total_demand = sumOfArray(demand);

        while (total_demand != 0 && total_supply != 0) {
            int minRow = 0;
            int minCol = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < cost.length; i++) { // Loop through rows
                for (int j = 0; j < cost[i].length; j++) { // Loop through columns
                    if (cost[i][j] <= min && demand[j] != 0 && supply[i] != 0) {
                        if (min == cost[i][j]) {
                            int allocation1 = Math.min(demand[minCol], supply[minRow]);
                            int allocation2 = Math.min(demand[j], supply[i]);
                            if (allocation2 > allocation1) {
                                minRow = i;
                                minCol = j;
                            }
                        } else {
                            minRow = i;
                            minCol = j;
                            min = cost[i][j];
                        }
                    }
                }
            }

            if (supply[minRow] > demand[minCol]) {
                allocation[minRow][minCol] = demand[minCol];
                supply[minRow] -= demand[minCol];
                total_demand -= demand[minCol];
                total_supply -= demand[minCol];
                demand[minCol] = 0;
            } else {
                allocation[minRow][minCol] = supply[minRow];
                demand[minCol] -= supply[minRow];
                total_demand -= supply[minRow];
                total_supply -= supply[minRow];
                supply[minRow] = 0;
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

        System.out.println("Total Cost = " + total_cost);

    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
