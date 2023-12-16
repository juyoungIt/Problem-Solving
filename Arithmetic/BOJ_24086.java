// BOJ - 24086
// Problem Sheet - https://www.acmicpc.net/problem/24086

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println(b - a);

        br.close();
        System.exit(0);
    }
}