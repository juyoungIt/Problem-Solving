// BOJ - 19817
// Problem Sheet - https://www.acmicpc.net/problem/19817

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static List<Integer>[] salaries;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        salaries = new ArrayList[n];
        for (int i=0 ; i<n ; i++) {
            salaries[i] = new ArrayList<>();
            String[] row = br.readLine().split(" ");
            int m = Integer.parseInt(row[0]);
            for (int j=0 ; j<m ; j++) {
                salaries[i].add(Integer.parseInt(row[j + 1]));
            }
            salaries[i].sort(Collections.reverseOrder());
        }
        br.close();
    }

    private static long solve() {
        long totalIncrements = 0;
        Arrays.sort(salaries, (s1, s2) -> s2.get(0) - s1.get(0));
        int maxSalary = salaries[0].get(0);
        for (int i=1 ; i<n ; i++) {
            totalIncrements += (long) (maxSalary - salaries[i].get(0)) * salaries[i].size();
        }
        return totalIncrements;
    }
}