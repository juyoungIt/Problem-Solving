// BOJ - 24082
// Problem Sheet - https://www.acmicpc.net/problem/24082

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(x, 3));

        br.close();
        System.exit(0);
    }
}