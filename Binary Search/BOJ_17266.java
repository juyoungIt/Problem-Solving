// BOJ - 17266
// Problem Sheet - https://www.acmicpc.net/problem/17266

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[] points = new int[m+2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<m+1 ; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        points[m+1] = n;

        int min = 0;
        int max = 100_001;
        int opt = 100_001;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(isCovered(points, mid)) {
                opt = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(opt);

        bf.close();
        System.exit(0);
    }

    private static boolean isCovered(int[] points, int height) {
        for(int i=1 ; i<points.length-1 ; i++) {
            int leftCovered = points[i] - height * 2;
            int rightCovered = points[i] + height * 2;
            if(i == 1) {
                leftCovered += height;
            }
            if(i == points.length-2) {
                rightCovered -= height;
            }
            if(leftCovered > points[i-1] || rightCovered < points[i+1]) {
                return false;
            }
        }
        return true;
    }
}