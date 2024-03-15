// BOJ - 29699
// Problem Sheet - https://www.acmicpc.net/problem/29699

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] tokens = "WelcomeToSMUPC".toCharArray();
        int n = Integer.parseInt(br.readLine());
        int targetIndex = n % tokens.length == 0 ? tokens.length - 1 : n % tokens.length - 1;
        System.out.println(tokens[targetIndex]);

        br.close();
        System.exit(0);
    }
}