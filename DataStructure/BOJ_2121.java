// BOJ - 2121
// Problem Sheet - https://www.acmicpc.net/problem/2121

import java.util.*;
import java.io.*;

public class Main {

    private static int n, a, b;
    private static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        a = Integer.parseInt(row[0]);
        b = Integer.parseInt(row[1]);
        map = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            int x = Integer.parseInt(row[0]);
            int y = Integer.parseInt(row[1]);
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        br.close();
    }

    private static int solve() {
        int rectCount = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int x = entry.getKey();
            for (int y : entry.getValue()) {
                if (isExist(x, y + b) && isExist(x + a, y) && isExist(x + a, y + b)) {
                    rectCount++;
                }
            }
        }
        return rectCount;
    }

    private static boolean isExist(int x, int y) {
        return map.containsKey(x) && map.get(x).contains(y);
    }

}