// BOJ - 29375
// Problem Sheet - https://www.acmicpc.net/problem/29375

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(arr);
        br.close();
    }

    private static double solve() {
        double danger = arr[0];
        for (int i=1 ; i<n ; i++) {
            danger = (danger + arr[i]) / 2;
        }
        return danger;
    }
}