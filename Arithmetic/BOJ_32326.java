// BOJ - 32326
// Problem Sheet - https://www.acmicpc.net/problem/32326

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int G = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.println(R * 3 + G * 4 + B * 5);
        br.close();
    }
}