// BOJ - 2121
// Problem Sheet - https://www.acmicpc.net/problem/2121

import java.util.*;
import java.io.*;

public class Main {

    private static int n, a, b;
    private static int[][] coords;

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
        coords = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            coords[i][0] = Integer.parseInt(row[0]);
            coords[i][1] = Integer.parseInt(row[1]);
        }
        Arrays.sort(coords, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c1[1] - c2[1];
            }
            return c1[0] - c2[0];
        });
        br.close();
    }

    private static int solve() {
        int rectCount = 0;
        for (int[] coord : coords) {
            if (isExist(coord[0], coord[1] + b)
                    && isExist(coord[0] + a, coord[1])
                    && isExist(coord[0] + a, coord[1] + b)) {
                rectCount++;
            }
        }
        return rectCount;
    }

    private static boolean isExist(int x, int y) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (coords[mid][0] == x) {
                if (coords[mid][1] < y) start = mid + 1;
                else if (coords[mid][1] > y) end = mid - 1;
                else return true;
            } else if (coords[mid][0] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}