import java.util.Scanner;

public class MinMaxServerLoad {

     public static int[] toBaseKArray(int number, int length) {
        int[] arr = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = number % 2;
            number /= 2;
        }
        return arr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Tasks : ");
        int tasks = sc.nextInt();
        System.out.println("Enter Number of Servers : ");
        int servers = sc.nextInt();

        int[] value_tasks = new int[tasks];
        int[] value_servers = new int[servers];

        for (int i = 0; i < tasks; i++) {
            System.out.println("Enter Task "+(i+1)+" :");
            value_tasks[i] = sc.nextInt();
        }

        int combination_total = (int) Math.pow(servers, tasks);

        int minOfMax = Integer.MAX_VALUE;

        for (int i = 0; i < combination_total; i++) {
            value_servers = new int[servers];
            int[] bin = toBaseKArray(i, tasks); // 0. 0. 0
            for (int j = 0; j < bin.length; j++) {
                value_servers[bin[j]] += value_tasks[j];
                
            }
            int max = Math.max(value_servers[0], value_servers[1]);

            minOfMax = Math.min(max, minOfMax);
        }

        System.out.println("Ans = "+minOfMax);
    }
}
