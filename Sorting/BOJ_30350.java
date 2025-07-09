// BOJ - 30350
// Problem Sheet - https://www.acmicpc.net/problem/30350

import java.io.*;
import java.util.Arrays;

public class Main {

    static class Route {
        int index;
        int rainfall;

        public Route(int index, int rainfall) {
            this.index = index;
            this.rainfall = rainfall;
        }
    }

    static int n, k;
    static Route[] routes;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        routes = new Route[n];
        for (int i=0 ; i<n ; i++) {
            int vi = Integer.parseInt(br.readLine());
            routes[i] = new Route(i + 1, vi);
        }
        br.close();
    }

    static String solve() {
        Arrays.sort(routes, (r1, r2) -> {
            if (r1.rainfall == r2.rainfall) return r1.index - r2.index;
            return r2.rainfall - r1.rainfall;
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<k ; i++) {
            sb.append(routes[i].index).append("\n");
        }
        return sb.toString();
    }

}