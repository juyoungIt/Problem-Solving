// BOJ - 24078
// Problem Sheet - https://www.acmicpc.net/problem/24078

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.println(x % 21);

        br.close();
        System.exit(0);
    }
}