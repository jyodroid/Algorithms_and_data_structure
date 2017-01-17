package algoritms_data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Staircase {

    private static int A = 1;
    private static int B = 2;
    private static int C = 3;

    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * Brute force try with memory for factorial calculations
     * @param n
     * @param memory
     */
    private static void calculateWays(int n, long[] memory) {
        int accum = 0;
        int x1 = n / A;
        while (x1 >= 0) {
            int x2 = 0;
            int x3 = 0;
            while (x2 <= n / B) {
                x3 = 0;
                accum += ways(x1, x2, x3, n, memory);
                while (x3 <= n / C) {
                    x3++;
                    accum += ways(x1, x2, x3, n, memory);
                }
                x2++;
            }
            x1--;
        }
        System.out.println(accum);
    }

    private static long ways(int x1, int x2, int x3, int n, long[] memory) {
        int operation = calculateOperation(x1, x2, x3);
        if (operation == n) {
            if (x1 * A == n) {
                return 1;
            } else if (x2 * B == n) {
                return 1;
            } else if (x3 * C == n) {
                return 1;
            } else {
                int sum = x1 + x2 + x3;
                //Combination with repeated numbers C = n!/x1!*x2!*x3!
                return memoriedFactorial(sum, memory) / (memoriedFactorial(x1, memory) * memoriedFactorial(x2, memory) * memoriedFactorial(x3, memory));
            }
        }
        return 0;
    }

    private static int calculateOperation(int x1, int x2, int x3) {
        return A * x1 + B * x2 + C * x3;
    }

    public static long memoriedFactorial(int n, long[] memory) {

        if (n == 0) {
            return 1;
        } else if (memory[n - 1] == 0) {
            memory[n - 1] = n * memoriedFactorial(n - 1, memory);
        }
        return memory[n - 1];
    }

    private static int climb(int n) {
        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        if (!map.containsKey(n)) {
            int count = climb(n - 1) + climb(n - 2) + climb(n - 3);
            map.put(n, count);
        }
        return map.get(n);
    }

    //Iterative version
    private static int iterativeClimb(int n) {

        //problem is in the form A * x1 + B * x2 + C * x3 = n so is polynomial lineal so it can be resolved with recursion
        //We want to find how many time can i down three then two then one and then combine.
        //since we want find f(n) = f(n - 3) + f(n - 2)
        //So we will need three first steps f(1) = 0, f(2) = 2, f(3) = 4 --> because we can climb 1 -> 1 or 2 so 2 possibilities

        for (int k = 1; k <= n; k++){
            int ways;
            if(k == 1){
                ways = 1;
            }else if(k == 2){
                ways = 2;
            }else if(k == 3){
                ways = 4;
            }else{
                ways = map.get(k-3) + map.get(k-2) + map.get(k-1);
            }
            map.put(k, ways);
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
//            long[] memory = new long[n];
//            calculateWays(n, memory);
            System.out.println(climb(n));
            System.out.println(iterativeClimb(n));
        }
    }
}
