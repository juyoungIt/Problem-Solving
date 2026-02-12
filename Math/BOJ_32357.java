// BOJ - 32357
// Problem Sheet - https://www.acmicpc.net/problem/32357

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tokens = new String[n];
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            tokens[i] = br.readLine();
            if (isPalindrome(tokens[i])) {
                count++;
            }
        }
        System.out.println(count * (count - 1));
        br.close();
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
