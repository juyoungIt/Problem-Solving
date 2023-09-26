// BOJ - 17362
// Problem Sheet - https://www.acmicpc.net/problem/17362

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result;

        if (n % 8 == 0) {
            result = 2;
        } else if (n % 4 == 3) {
            result = 3;
        } else if (n % 8 == 6) {
            result = 4;
        } else {
            result = n % 8;
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}