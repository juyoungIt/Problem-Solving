// BOJ - 14671
// Problem Sheet - https://www.acmicpc.net/problem/14671

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean[][] identifier = new boolean[2][2];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            identifier[x%2][y%2] = true;
        }

        if(identifier[0][0] && identifier[0][1] && identifier[1][0] && identifier[1][1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        bf.close();
        System.exit(0);
    }
}