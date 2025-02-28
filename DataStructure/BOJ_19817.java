// BOJ - 19817
// Problem Sheet - https://www.acmicpc.net/problem/19817

import java.io.*;

public class Main {

    private static int n;
    private static int[] maxSalaries;
    private static int[] sizes;
    private static int topSalary = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maxSalaries = new int[n];
        sizes = new int[n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            sizes[i] = Integer.parseInt(row[0]);
            for (int j=1 ; j<=sizes[i] ; j++) {
                maxSalaries[i] = Math.max(maxSalaries[i], Integer.parseInt(row[j]));
                topSalary = Math.max(topSalary, maxSalaries[i]);
            }
        }
        br.close();
    }

    private static long solve() {
        long totalIncrements = 0;
        for (int i=0 ; i<n ; i++) {
            totalIncrements += (long) (topSalary - maxSalaries[i]) * sizes[i];
        }
        return totalIncrements;
    }
}