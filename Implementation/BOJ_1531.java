// BOJ - 1531
// Problem Sheet - https://www.acmicpc.net/problem/1531

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int[][] layered = new int[101][101];
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            int lbx = Integer.parseInt(row[0]);
            int lby = Integer.parseInt(row[1]);
            int rtx = Integer.parseInt(row[2]);
            int rty = Integer.parseInt(row[3]);
            for (int y=lby ; y<=rty ; y++) {
                for (int x=lbx ; x<=rtx ; x++) {
                    layered[y][x]++;
                }
            }
        }
        int answer = 0;
        for (int y=0 ; y<=100 ; y++) {
            for (int x=0 ; x<=100 ; x++) {
                if (layered[y][x] <= m) continue;
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
