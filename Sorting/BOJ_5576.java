// BOJ - 5576
// Problem Sheet - https://www.acmicpc.net/problem/5576

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] w = new int[10];
        int[] k = new int[10];
        for (int i=0 ; i<10 ; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0 ; i<10 ; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);
        Arrays.sort(k);

        int scoreOfW = 0;
        int scoreOfK = 0;
        for (int i=9 ; i>6 ; i--) {
            scoreOfW += w[i];
            scoreOfK += k[i];
        }

        System.out.printf("%d %d\n", scoreOfW, scoreOfK);

        br.close();
        System.exit(0);
    }
}