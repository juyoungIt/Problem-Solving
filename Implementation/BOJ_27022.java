// BOJ - 27022
// Problem Sheet - https://www.acmicpc.net/problem/27022

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int d = Integer.parseInt(br.readLine());
        Set<Integer> xRoute = new HashSet<>();
        Set<Integer> yRoute = new HashSet<>();
        int x = 0, y = 0;
        while (d-- > 0) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());
            if (dir == 'N') {
                y += dist;
                xRoute.add(x);
            } else if (dir == 'S') {
                y -= dist;
                xRoute.add(x);
            } else if (dir == 'E') {
                x += dist;
                yRoute.add(y);
            } else {
                x -= dist;
                yRoute.add(y);
            }
        }
        System.out.println(xRoute.size() + yRoute.size());
        br.close();
    }
}