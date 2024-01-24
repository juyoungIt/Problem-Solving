// BOJ - 27389
// Problem Sheet - https://www.acmicpc.net/problem/27389

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.printf("%.2f\n", (double)n / 4);
        br.close();
    }
}