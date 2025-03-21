// BOJ - 32205
// Problem Sheet - https://www.acmicpc.net/problem/32205

import java.util.*;
import java.io.*;

public class Main {

    static class Triangle {
        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() { return this.a; }
        public int getB() { return this.b; }
        public int getC() { return this.c; }
    }

    private static Map<Integer, List<Triangle>> triangles;

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
            Triangle triangle = new Triangle(a, b, c);
            if (!triangles.containsKey(a)) triangles.put(a, new ArrayList<>());
            if (!triangles.containsKey(b)) triangles.put(b, new ArrayList<>());
            if (!triangles.containsKey(c)) triangles.put(c, new ArrayList<>());
            triangles.get(a).add(triangle);
            triangles.get(b).add(triangle);
            triangles.get(c).add(triangle);
        }
        br.close();
    }

    private static boolean solve() {
        for (List<Triangle> tg : triangles.values()) {
            if (tg.size() >= 2) return true;
        }
        return false;
    }

}
