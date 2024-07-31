// BOJ - 31606
// Problem Sheet - https://www.acmicpc.net/problem/31606

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        System.out.println(x + y + 3);

        br.close();
        System.exit(0);
    }
}