// BOJ - 31614
// Problem Sheet - https://www.acmicpc.net/problem/31614

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println(h * 60 + m);

        br.close();
        System.exit(0);
    }
}