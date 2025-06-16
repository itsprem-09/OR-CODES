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

        int[] row_penalty = new int[3];

        int[] col_penalty = new int[4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                row_penalty[i] = getPenalty(cost[i]);
                col_penalty[j] = getPenalty(getColumn(cost, j));
            }
        }

        int max_penalty = getMaxPenalty(row_penalty, col_penalty);

        

    }

    public static int getPenalty(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num > min1 && num < min2) {
                min2 = num;
            }
        }
        return min1 - min2;
    }

    public static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    public static int getMaxPenalty(int[] row_penalty, int[] col_penalty){
         int max = Integer.MIN_VALUE;

        // Check elements in the first array
        for (int num : row_penalty) {
            if (num > max) {
                max = num;
            }
        }

        // Check elements in the second array
        for (int num : col_penalty) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

}
