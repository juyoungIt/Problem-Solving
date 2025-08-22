// BOJ - 17290
// Problem Sheet - https://www.acmicpc.net/problem/17290

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        boolean[] isDangerRow = new boolean[11];
        boolean[] isDangerCol = new boolean[11];
        for (int i=1 ; i<=10 ; i++) {
            String row = br.readLine();
            for (int j=1 ; j<=10 ; j++) {
                if (row.charAt(j - 1) == 'o') {
                    isDangerRow[i] = true;
                    isDangerCol[j] = true;
                }
            }
        }
        int minDist = 21;
        for (int i=1 ; i<=10 ; i++) {
            for (int j=1 ; j<=10 ; j++) {
                if (isDangerRow[i] || isDangerCol[j]) continue;
                int dist = Math.abs(r - i) + Math.abs(c - j);
                minDist = Math.min(minDist, dist);
            }
        }
        System.out.println(minDist);
        br.close();
    }
}