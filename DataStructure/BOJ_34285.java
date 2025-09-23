// BOJ - 34285
// Problem Sheet - https://www.acmicpc.net/problem/34285

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, int[]> landmarkMap = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            String name = row[0];
            int x = Integer.parseInt(row[1]);
            int y = Integer.parseInt(row[2]);
            landmarkMap.put(name, new int[]{x, y});
        }
        String[] route = br.readLine().trim().split("\\s+");
        int totalDist = 0;
        for (int i=1 ; i<route.length ; i++) {
            int[] prev = landmarkMap.get(route[i - 1]);
            int[] cur = landmarkMap.get(route[i]);
            totalDist += getDist(prev[0], prev[1], cur[0], cur[1]);
        }
        System.out.println(totalDist);
        br.close();
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}