// BOJ - 34071
// Problem Sheet - https://www.acmicpc.net/problem/34071

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int first = 0, min = 1_001, max = 0;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());
                if (i == 0) {
                    first = x;
                }
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            if (min == first) {
                System.out.println("ez");
            } else if (max == first) {
                System.out.println("hard");
            } else {
                System.out.println("?");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}