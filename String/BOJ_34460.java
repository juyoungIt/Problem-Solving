// BOJ - 34460
// Problem Sheet - https://www.acmicpc.net/problem/34460

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();
            boolean isValid = true;
            char prev = s.charAt(0);
            if (prev == 'M') {
                for (int i=1 ; i<len ; i++) {
                    char cur = s.charAt(i);
                    if (!isValidComb(prev, cur)) {
                        isValid = false;
                        break;
                    }
                    prev = cur;
                }
                if (prev != 'T') isValid = false;
            } else {
                isValid = false;
            }
            sb.append(isValid ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isValidComb(char prev, char cur) {
        return (prev == 'M' && cur == 'I')
                || (prev == 'I' && cur == 'T')
                || (prev == 'T' && (cur == 'I' || cur == 'M')
        );
    }
}