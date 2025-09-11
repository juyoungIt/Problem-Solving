// BOJ - 11534
// Problem Sheet - https://www.acmicpc.net/problem/11534

import java.util.*;
import java.io.*;

public class Main {

    private static final String PASS = "PASS";
    private static final String FAIL = "FAIL";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        char[] p = row[0].toCharArray();
        char[] s = row[1].toCharArray();

        int pIdx = 0;
        boolean isValid = true;
        for (int i=0 ; i<s.length ; i++) {
            if (pIdx == p.length) {
                break;
            }
            if (s[i] != p[pIdx] && contains(p, s[i], pIdx)) {
                isValid = false;
                break;
            }
            if (s[i] == p[pIdx]) {
                pIdx++;
            }
        }

        if (pIdx < p.length) isValid = false;

        System.out.println(isValid ? PASS : FAIL);
        br.close();
    }

    private static boolean contains(char[] arr, char c, int s) {
        for (int i=s ; i<arr.length ; i++) {
            if (arr[i] == c) {
                return true;
            }
        }
        return false;
    }

}
