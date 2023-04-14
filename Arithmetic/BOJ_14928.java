// BOJ - 14928
// Problem Sheet - https://www.acmicpc.net/problem/14928

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        long remainder = 0;
        for (int i = 0; i < number.length(); i++) {
            remainder = (remainder * 10 + (number.charAt(i) - '0')) % 20000303;
        }

        System.out.println(remainder);

        bf.close();
        System.exit(0);
    }
}