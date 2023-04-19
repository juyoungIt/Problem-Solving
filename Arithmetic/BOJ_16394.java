// BOJ - 16394
// Problem Sheet - https://www.acmicpc.net/problem/16394

import java.io.*;

public class Main {

    private static final int BASE_YEAR = 1946;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int currentYear = Integer.parseInt(bf.readLine());

        System.out.println(currentYear - BASE_YEAR);

        bf.close();
        System.exit(0);
    }
}