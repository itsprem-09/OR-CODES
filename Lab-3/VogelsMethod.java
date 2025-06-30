public class VogelsMethod {
    public static void main(String[] args) {
        int[][] cost = {
                { 12, 10, 12, 13 },
                { 7, 11, 8, 14 },
                { 6, 16, 11, 7 }
        };

        int[] demand = { 180, 150, 350, 320 };
        int[] supply = { 500, 300, 200 };

        int[][] allocation = new int[3][4];

        boolean[] isRowDone = new boolean[3];
        boolean[] isColDone = new boolean[4];

        while (!allDone(isRowDone, isColDone)) {

            int[] rowPenalty = new int[3];
            int[] colPenalty = new int[4];

            // Calculate penalties

            for (int i = 0; i < 3; i++) {
                if (!isRowDone[i]) {
                    rowPenalty[i] = getPenalty(cost[i], isColDone);
                }
            }

            for (int j = 0; j < 4; j++) {
                if (!isColDone[j]) {
                    colPenalty[j] = getPenalty(getColumn(cost, j), isRowDone);
                }
            }

            // Decide whether to use row or column penalty
            int maxPenalty = -1;
            boolean isRow = true;
            int index = -1;

            for (int i = 0; i < rowPenalty.length; i++) {
                if (rowPenalty[i] > maxPenalty) {
                    maxPenalty = rowPenalty[i];
                    index = i;
                    isRow = true;
                }
            }

            for (int j = 0; j < colPenalty.length; j++) {
                if (colPenalty[j] > maxPenalty) {
                    maxPenalty = colPenalty[j];
                    index = j;
                    isRow = false;
                }
            }

            int selectedRow = -1, selectedCol = -1;

            // Find the minimum cost cell in the selected row/column

            if (isRow) {
                selectedRow = index;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < 4; j++) {
                    if (!isColDone[j] && cost[selectedRow][j] < min) {
                        min = cost[selectedRow][j];
                        selectedCol = j;
                    }
                }
            } else {
                selectedCol = index;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (!isRowDone[i] && cost[i][selectedCol] < min) {
                        min = cost[i][selectedCol];
                        selectedRow = i;
                    }
                }
            }

            // Allocate

            int quantity = Math.min(supply[selectedRow], demand[selectedCol]);
            allocation[selectedRow][selectedCol] = quantity;
            supply[selectedRow] -= quantity;
            demand[selectedCol] -= quantity;

            // Mark exhausted rows/columns

            if (supply[selectedRow] == 0) {
                isRowDone[selectedRow] = true;
            }

            if (demand[selectedCol] == 0) {
                isColDone[selectedCol] = true;
            }

        }

        System.out.println("Final Allocation:");
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < allocation[0].length; j++) {
                System.out.print(allocation[i][j] + "\t");
            }
            System.out.println();
        }

        int totalCost = 0;
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < allocation[0].length; j++) {
                totalCost += allocation[i][j] * cost[i][j];
            }
        }
        System.out.println("Total Transportation Cost: " + totalCost);

    }

    public static int getPenalty(int[] arr, boolean[] doneMask) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (doneMask[i])
                continue;
            int num = arr[i];
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return (min2 == Integer.MAX_VALUE) ? 0 : (min2 - min1);
    }

    public static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    public static boolean allDone(boolean[] rows, boolean[] cols) {
        for (boolean b : rows)
            if (!b)
                return false;
        for (boolean b : cols)
            if (!b)
                return false;
        return true;
    }

}
