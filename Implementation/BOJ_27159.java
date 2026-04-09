// BOJ - 27159
// Problem Sheet - https://www.acmicpc.net/problem/27159

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = 0;
        int prev = 0;
        for (int i=0 ; i<n ; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (card != prev + 1) {
                score += card;
            }
            prev = card;
        }
        System.out.println(score);
        br.close();
    }
}