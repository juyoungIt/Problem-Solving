// BOJ - 15970
// Problem Sheet - https://www.acmicpc.net/problem/15970

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[][] points = new int[N][2];
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, (o1, o2) -> {
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int totalDistance = 0;
        for(int i=0 ; i<N ; i++) {
            int leftDistance = 100_000;
            int rightDistance = 100_000;
            if(i-1 >= 0 && points[i-1][1] == points[i][1]) leftDistance = points[i][0] - points[i-1][0];
            if(i+1 < N && points[i+1][1] == points[i][1]) rightDistance = points[i+1][0] - points[i][0];
            totalDistance += Math.min(leftDistance, rightDistance);
        }

        System.out.println(totalDistance);

        bf.close();
        System.exit(0);
    }
}