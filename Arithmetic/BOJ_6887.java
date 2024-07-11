// BOJ - 6887
// Problem Sheet - https://www.acmicpc.net/problem/6887

import java.io.*;

public class Main {

    private static final String MESSAGE_FORMAT = "The largest square has side length %d.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = (int) Math.sqrt(n);
        System.out.printf(MESSAGE_FORMAT, answer);

        br.close();
        System.exit(0);
    }
}