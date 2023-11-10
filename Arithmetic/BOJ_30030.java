// BOJ - 30030
// Problem Sheet - https://www.acmicpc.net/problem/30030

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(bf.readLine());
        int a = b * 10 / 11;

        System.out.println(a);

        bf.close();
        System.exit(0);
    }
}