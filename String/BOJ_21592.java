// BOJ - 21592
// Problem Sheet - https://www.acmicpc.net/problem/21592

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        int start = 1, end = 101;
        for (int i=0 ; i<n ; i++) {
            s[i] = br.readLine();
            end = Math.min(end, s[i].length());
        }

        int maxLen = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (hasLCS(s, mid)) {
                start = mid + 1;
                maxLen = Math.max(maxLen, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(maxLen);
        br.close();
    }

    private static boolean hasLCS(String[] s, int l) {
        for (int i=0 ; i<=s[0].length()-l ; i++) {
            String p = s[0].substring(i, i + l);
            boolean hasLCS = true;
            for (int j=1 ; j<s.length ; j++) {
                if (!hasLCS(s[j], p)) {
                    hasLCS = false;
                    break;
                }
            }
            if (hasLCS) return true;
        }
        return false;
    }

    private static boolean hasLCS(String s, String p) {
        for (int i=0 ; i<=s.length()-p.length() ; i++) {
            if (s.startsWith(p, i)) return true;
        }
        return false;
    }
}