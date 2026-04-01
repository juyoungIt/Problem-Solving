// BOJ - 15051
// Problem Sheet - https://www.acmicpc.net/problem/15051

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        for (int i=0 ; i<3 ; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int[] costs = new int[3];
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                costs[i] += Math.abs(i - j) * a[j] * 2;
            }
        }
        System.out.println(Math.min(costs[0], Math.min(costs[1], costs[2])));
        br.close();
    }
}