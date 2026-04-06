// BOJ - 9610
// Problem Sheet - https://www.acmicpc.net/problem/9610

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] quadrant = new int[5];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 || y == 0) {
                quadrant[0]++;
            } else if (x > 0 && y > 0) {
                quadrant[1]++;
            } else if (y > 0) {
                quadrant[2]++;
            } else if (x < 0) {
                quadrant[3]++;
            } else {
                quadrant[4]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Q1: ").append(quadrant[1]).append("\n");
        sb.append("Q2: ").append(quadrant[2]).append("\n");
        sb.append("Q3: ").append(quadrant[3]).append("\n");
        sb.append("Q4: ").append(quadrant[4]).append("\n");
        sb.append("AXIS: ").append(quadrant[0]);
        System.out.println(sb);
        br.close();
    }
}