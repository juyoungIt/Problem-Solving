// BOJ - 14247
// Problem Sheet - https://www.acmicpc.net/problem/14247

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] heights = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            heights[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            heights[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(heights, Comparator.comparingInt(g -> g[1]));

        for (int i=0 ; i<n ; i++) {
            heights[i][0] += heights[i][1] * i;
        }

        long totalLength = 0;
        for (int[] height : heights) {
            totalLength += height[0];
        }
        System.out.println(totalLength);

        br.close();
        System.exit(0);
    }
}