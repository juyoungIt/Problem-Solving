// BOJ - 6749
// Problem Sheet - https://www.acmicpc.net/problem/6749

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        System.out.println(m + (m - y));
        br.close();
    }
}