// BOJ - 22076
// Problem Sheet - https://www.acmicpc.net/problem/22076

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        map = new HashMap<>();
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            int color = Integer.parseInt(row[i]);
            if (!map.containsKey(color)) map.put(color, 0);
            map.put(color, map.get(color) + 1);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>(map.keySet());
        while (k > 0) {
            for (int key : queue) {
                if (map.get(key) == 0) continue;
                sb.append(key).append(" ");
                map.put(key, map.get(key) - 1);
                k--;
                if (k == 0) break;
            }
        }
        return sb.toString();
    }
}