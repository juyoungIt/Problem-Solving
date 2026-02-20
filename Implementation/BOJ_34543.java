// BOJ - 34543
// Problem Sheet - https://www.acmicpc.net/problem/34543

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int score = n * 10;
        if (n >= 3) score += 20;
        if (n == 5) score += 50;
        if (w > 1_000) score -= 15;
        score = Math.max(score, 0);
        System.out.println(score);
        br.close();
    }
}
