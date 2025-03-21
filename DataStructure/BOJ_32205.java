// BOJ - 32205
// Problem Sheet - https://www.acmicpc.net/problem/32205

import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer, Integer> triangles;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve() ? 1 : 0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        triangles = new HashMap<>();
        while (N-- > 0) {
            String[] rect = br.readLine().split(" ");
            int a = Integer.parseInt(rect[0]);
            int b = Integer.parseInt(rect[1]);
            int c = Integer.parseInt(rect[2]);
            triangles.put(a, triangles.getOrDefault(a, 0) + 1);
            triangles.put(b, triangles.getOrDefault(b, 0) + 1);
            triangles.put(c, triangles.getOrDefault(c, 0) + 1);
        }
        br.close();
    }

    private static boolean solve() {
        for (int count : triangles.values()) {
            if (count >= 2) return true;
        }
        return false;
    }

}
