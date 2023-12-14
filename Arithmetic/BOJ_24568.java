// BOJ - 24568
// Problem Sheet - https://www.acmicpc.net/problem/24568

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int regularCnt = Integer.parseInt(br.readLine());
        int smallCnt = Integer.parseInt(br.readLine());

        System.out.println(regularCnt * 8 + smallCnt * 3 - 28);

        br.close();
        System.exit(0);
    }
}