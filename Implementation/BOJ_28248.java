// BOJ - 28248
// Problem Sheet - https://www.acmicpc.net/problem/28248

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println(p * 50 - c * 10 + (p > c ? 500 : 0));
        br.close();
    }
}
