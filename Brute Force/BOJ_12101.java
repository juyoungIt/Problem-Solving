// BOJ - 12101
// Problem Sheet - https://www.acmicpc.net/problem/12101

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static List<String> exprList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve("", 0, n);
        Collections.sort(exprList);
        System.out.println(k - 1 < exprList.size() ? exprList.get(k - 1) : -1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        br.close();
    }

    private static void solve(String expr, int acc, int target) {
        if (acc >= target) {
            if (acc == target) {
                exprList.add(expr);
            }
            return;
        }
        for (int i=1 ; i<=3 ; i++) {
            if (acc == 0) solve(Integer.toString(i), acc + i, target);
            else solve(expr + "+" + i, acc + i, target);
        }
    }
}