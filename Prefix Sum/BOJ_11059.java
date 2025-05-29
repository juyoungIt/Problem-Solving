// BOJ - 11059
// Problem Sheet - https://www.acmicpc.net/problem/11059

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length() + 1];
        int[] acc = new int[str.length() + 1];
        for (int i=1 ; i<=str.length() ; i++) {
            arr[i] = str.charAt(i - 1) - '0';
            acc[i] = acc[i - 1] + arr[i];
        }

        int maxLen = 0;
        for (int len=str.length() ; len>0 ; len--) {
            if (len % 2 != 0) continue;
            for (int i=0 ; i<=str.length()-len ; i++) {
                int frontSum = acc[i + len / 2] - acc[i];
                int backSum = acc[i + len] - acc[i + len / 2];
                if (frontSum == backSum) {
                    maxLen = len;
                    break;
                }
            }
            if (maxLen > 0) break;
        }

        System.out.println(maxLen);
        br.close();
    }
}