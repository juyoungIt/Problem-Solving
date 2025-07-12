// BOJ - 16304
// Problem Sheet - https://www.acmicpc.net/problem/16304

import java.util.*;
import java.io.*;

public class Main {

    static int n, x;
    static int[] items;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        x = Integer.parseInt(row[1]);
        items = new int[n];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            items[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    static int solve() {
        Arrays.sort(items);
        int targetIndex = 0;
        for (int i=1 ; i<n ; i++) {
            if (items[i - 1] + items[i] > x) break;
            targetIndex = i;
        }
        return targetIndex + 1;
    }

}